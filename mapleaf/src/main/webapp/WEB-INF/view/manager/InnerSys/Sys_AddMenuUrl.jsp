<%@ include file="../../common/Head.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
	<div style="position:relative; margin: 0 auto; width: 99.5%; height: 95%; padding-top: 5px; padding-left: 3px;padding-right: 3px;">
		<div style="width: 100%;height: 100%;border:1px solid #ccc;border-radius:3px;">
			<div id="tb">
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="addUrlDialog()" data-options="iconCls:'icon-add',plain:true">增加</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="deleteDialog()" data-options="iconCls:'icon-cancel',plain:true">删除</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="editUrlDialog()" data-options="iconCls:'icon-edit',plain:true">修改</a>
			</div>
			<table id="dg" class="easyui-datagrid" style="height:100%" data-options="singleSelect:true">
				<thead>
					<tr>
						 <th data-options="field:'dh'" hidden="true">菜单名称</th>
						 <th data-options="field:'text'" width="33%">菜单名称</th>
						 <th data-options="field:'urltype'" width="33%">URL类型</th>
						 <th data-options="field:'url'" width="33%">菜单URL</th>
					</tr>
				</thead>
			</table>
		</div>
		<div id="urldialog" class="easyui-dialog" data-options="resizable:true" closed="true">
			<form id="fm_url" method="post" enctype="multipart/form-data">
				<div style="padding: 10px;width:300px;height: 200px; font-family: sans-serif;" align="center">
					<table>
						<tr align="center">
							<td style="width: 80px; padding: 10px;" align="right">菜单名称:</td>
							<td style="padding: 10px;" align="left"><input class="easyui-textbox textbox-f" type="text" id="text" name="text"/></td>
						</tr>
						<tr align="center" >
							<td style="width: 80px; padding: 10px;"  align="right">url类型:</td>
							<td style="padding: 10px;" align="left"><input class="easyui-textbox textbox-f" type="text" id="urltype" name="urltype"/></td>
						</tr>
						<tr align="center">
							<td style="width: 80px; padding: 10px;" align="right">菜单url:</td>
							<td style="padding: 10px;" align="left"><input class="easyui-textbox textbox-f" type="text" id="url" name="url"/></td>
						</tr>
						<tr >
							<td colspan="2"  style="padding: 10px;" align="center">
								<div>
									<a href="javascript:void(0)" class="easyui-linkbutton" id="saveurl" onclick="saveurl()" style="width: 80px;margin-right: 20px;">保存</a>
							 		<a href="javascript:void(0)" class="easyui-linkbutton" id="cancelurl" onclick="cancelurl()" style="width: 80px">取消</a>
								</div>
							</td>
						</tr>
					</table>
				</div>
			</form>
		</div>
	</div>
	<script>
	
	var buttonType = null;
	var dh = null;
	
	$(function(){
		$("#dg").datagrid({
			url:"../sysManager/pzurl",
			toolbar:"#tb",
			pagination:true,
			rownumbers:true,
			pageSize:20,
			fit:true,
			loadFilter:pagerFilter
		});
		
		function pagerFilter(data){
			if (typeof data.length == 'number' && typeof data.splice == 'function'){	// is array
				data = {
					total: data.length,
					rows: data
				}
			}
			var dg = $(this);
			var opts = dg.datagrid('options');
			var pager = dg.datagrid('getPager');
			pager.pagination({
				onSelectPage:function(pageNum, pageSize){
					opts.pageNumber = pageNum;
					opts.pageSize = pageSize;
					pager.pagination('refresh',{
						pageNumber:pageNum,
						pageSize:pageSize
					});
					dg.datagrid('loadData',data);
				}
			});
			if (!data.originalRows){
				data.originalRows = (data.rows);
			}
			var start = (opts.pageNumber-1)*parseInt(opts.pageSize);
			var end = start + parseInt(opts.pageSize);
			data.rows = (data.originalRows.slice(start, end));
			return data;
		}
	});
	function init(){
		buttonType = null;
		dh = null;
		$("#fm_url").form("clear");
	}
	
	function addUrlDialog(){
		init();
		$("#urldialog").dialog("open").dialog("setTitle","增加");
		buttonType = "add";
	}
	
	function deleteDialog(){
		init();
		var row = $("#dg").datagrid("getSelected");
		$.ajax({
			type : "post",
			url : "../sysManager/deleteUrlByDh?dh=" + row.dh,
			data : null,
			async : true,
			cache : false,
			success : function(msg) {
				$("#dg").datagrid("reload");
			}
		});
	}
	
	function editUrlDialog(){
		init();
		var row = $("#dg").datagrid("getSelected");
		if(row == null || row == ""){
			alert("请选择,修改行！");
			return false;
		}
		$("#urldialog").dialog("open").dialog("setTitle","修改");
		$("#fm_url").form("load",row);
		buttonType = "edit"
		dh = row.dh;
	}
	
	function saveurl(){
		if(dh == null){
			dh = getDh();
		}
		var text = $("#text").val();
		var urltype = $("#urltype").val();
		var url = $("#url").val();
		
		if(dh == null || dh == "" || dh == "null"){
			alert("生成单号失败");
			return false;
		}
		
		if(text == null || text == "" || text == "null"){
			alert("菜单名称不能为空");
			return false;
		}
		if(urltype == null || urltype == "" || urltype == "null"){
			alert("URL类型不能为空");
			return false;
		}
		if(url == null || url == "" || url == "null"){
			alert("菜单URL不能为空");
			return false;
		}
				
		$("#fm_url").form('submit',{
			url:"../sysManager/addurl?dh=" + dh + "&text=" + text + "&url=" + url + "&urltype=" + urltype + "&type=" + buttonType,
			success:function(data){
				console.log(data);
				$("#dg").datagrid("reload");
			}
		});
		
		$("#urldialog").dialog("close");
	
	}
	
	function cancelurl(){
		init();
		$("#urldialog").dialog("close");
	}
		
	function getDh(){
		var myDate = new Date();
		var year = myDate.getFullYear();
		var month = myDate.getMonth();
		var day = myDate.getDay();
		var h = myDate.getHours();
		var m = myDate.getMinutes();
		var s = myDate.getSeconds();
		if(month < 10) month = "0" + month;
		if(day < 10) day = "0" + day;
		if(h < 10) h = "0" + h;
		if(m < 10) m = "0" + m;
		if(s < 10) s = "0" + s;
		return "dh" + year + "" + month + "" + day + "" + h + "" + m + "" + s + "_" + parseInt(1000*Math.random());
	}
	
	</script>
</body>

