<%@ include file="../../common/Head.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
	<div style="position:relative; margin: 0 auto; width: 99.5%; height: 95%; padding-top: 5px; padding-left: 3px;padding-right: 3px;">
		<div style="float:left;width: 48%;height: 100%;border:1px solid #ccc;border-radius:3px;">
			<div class="easyui-panel" style="padding:5px">
				<ul id="directoryTree" class="easyui-tree"></ul>
			</div>
		</div>
		<div  style="float:right; width: 48%;height: 100%;border:1px solid #ccc;border-radius:3px;">
			<div id="directoryTb">
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="addDirectory()" data-options="iconCls:'icon-add',plain:true">增加</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="deleteDirectory()" data-options="iconCls:'icon-cancel',plain:true">删除</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="editDirectory()" data-options="iconCls:'icon-edit',plain:true">修改</a>
			</div>
			<table id="directoryDg" class="easyui-datagrid" style="height:100%" data-options="singleSelect:true">
				<thead>
					<tr>
						 <th data-options="field:'dh'" hidden="true">单号</th>
						 <th data-options="field:'text'" width="33%">菜单名称</th>
						 <th data-options="field:'url'" width="33%">菜单URL</th>
						 <th data-options="field:'sort'" width="33%">排序</th>
					</tr>
				</thead>
			</table>
			<div id="directoryDialog" class="easyui-dialog" data-options="resizable:true" closed="true" style="width: 380px;height: 300px">
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
								<td style="width: 80px; padding: 10px;" align="right">url:</td>
								<td style="padding: 10px;" align="left">
									<input class="easyui-combobox" type="text" id="url" name="url" data-options="valueField: 'url',textField: 'text',labelPosition: 'top'"/>
								</td>
							</tr>
							<tr align="center" >
								<td style="width: 80px; padding: 10px;"  align="right">sort:</td>
								<td style="padding: 10px;" align="left"><input class="easyui-textbox textbox-f" type="text" id="sortML" name="sort"/></td>
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
		</div >
	</div>
<script>


	var id_forward = null;
	var dh = null;
	var buttonType = null;
	
	$(function(){
		loadTree();
		$("#directoryDg").datagrid({
			url:"../sysManager/getManageSysByid?id=0"
		});
		
		
	})
	
	function init(){
		dh = null;
		buttonType = null;
		$("#fm_url").form("clear");
	}
	
	function loadTree(){
		
		$("#directoryDg").datagrid({
			url:"../sysManager/getManageSysByid?id=null",
			toolbar:"#directoryTb",
			rownumbers:true,
		});
		
		$("#directoryTree").tree({
			url:"../sysManager/loadMenuTree?id=0",
			method:"post",
			animate:true,
			onLoadSuccess:function(msg){
			},
			onClick:function(node){
				$("#directoryDg").datagrid({
					url:"../sysManager/getManageSysByid?id=" + node.id,
				});
				$("#directoryDg").datagrid("reload");
				id_forward = node.id;
			}
		});
	}
	
	function loadComBox(){
		$('#url').combobox('reload', '../sysManager/getAllManageUrl')
	}
	
	function addDirectory(){
		init();
		loadComBox();
		buttonType = "add";
		$("#directoryDialog").dialog("open").dialog("setTitle","增加");
	}
	
	function deleteDirectory(){
		init();
		var row = $("#directoryDg").datagrid("getSelected");
		$.ajax({
			type : "post",
			url : "../sysManager/deleteManageSysByDh?dh=" + row.dh,
			data : null,
			async : true,
			cache : false,
			success : function(msg) {
				$("#directoryDg").datagrid("reload");
			}
		});
	}
	
	function editDirectory(){
		init();
		loadComBox();
		buttonType = "edit";
		var row = $("#directoryDg").datagrid("getSelected");
		if(row == null || row == ""){
			alert("请选择,修改行！");
			return false;
		}
		$("#fm_url").form("load",row);
		dh = row.dh;
		$("#directoryDialog").dialog("open").dialog("setTitle","修改");
	}
	
	function saveurl(){
		
		var id = null;
		var f_id = null;
		
		if(dh == null){
			dh = getDh();
			if(id_forward == null){
				id_forward = 0;
			}
			f_id = id_forward;
			var number = $("#directoryDg").datagrid("getData").total + 1;
			if(number < 10) number = "0" + number;
			id = f_id + "" + number;
		}
		
		var text = $("#text").val();
		var urltype = $("#urltype").val();
		var url = $("#url").val();
		var sortML = $("#sortML").val();
		
		
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
		
		if(sortML == null || sortML == "" || sortML == "null"){
			alert("请排序");
			return false;
		}
		
		console.log("dh=" + dh + " id=" + id + " f_id" + f_id + " text=" + text + " urltype=" + urltype + " url=" + url + " sortML=" + sortML);
		
		$("#fm_url").form('submit',{
			url:"../sysManager/gxDirectory?dh=" + dh + "&id=" + id + "&f_id=" + f_id + "&text=" + text + "&url=" + url + "&urltype=" + urltype + "&sort=" + sortML + "&gxtype=" + buttonType,
			success:function(data){
				console.log(data);
				$("#directoryDg").datagrid("reload");
			}
		});
		$("#directoryDialog").dialog("close");
		
	}
	
	function cancelurl(){
		$("#directoryDialog").dialog("close");
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
