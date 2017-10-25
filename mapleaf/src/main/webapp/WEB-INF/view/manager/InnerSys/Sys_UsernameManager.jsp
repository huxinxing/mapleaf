<%@ include file="../../common/Head.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
	<div style="position:relative; margin: 0 auto; width: 99.5%; height: 95%; padding-top: 5px; padding-left: 3px;padding-right: 3px;">
		<div style="width: 100%;height: 100%;border:1px solid #ccc;border-radius:3px;">
			<div id="UserTb" style="padding-top: 5px;padding-bottom: 5px;">
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="addUser()" data-options="iconCls:'icon-add',plain:true">增加</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="deleteUser()" data-options="iconCls:'icon-cancel',plain:true">删除</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="editUser()" data-options="iconCls:'icon-edit',plain:true">修改</a>
				<div style="position:relation;display: inline;float: right; margin-right: 20px;">
					<input class="easyui-textbox" id="UserSearch" style="width:240px; height: 25px;">
					<a href="#" class="easyui-linkbutton" onclick="UserSearch()" iconCls="icon-search" style="width:60px;height: 25px;">查找</a>
				</div>
			</div>
			<table id="Sys_UserDg" class="easyui-datagrid" style="height:100%" data-options="singleSelect:true">
				<thead>
					<tr>
						 <th data-options="field:'humanId'" width="12%">人员ID</th>
						 <th data-options="field:'username'" width="12%">标识名</th>
						 <th data-options="field:'password'" width="12%">标识密码</th>
						 <th data-options="field:'name'" width="12%">名字</th>
						 <th data-options="field:'sex'" width="4%">性别</th>
						 <th data-options="field:'birthday'" width="12%">出生日期</th>
						 <th data-options="field:'age'" width="8%">年龄</th>
						 <th data-options="field:'phone'" width="12%">手机号码</th>
						 <th data-options="field:'email'" width="16%">电子邮件</th>
					</tr>
				</thead>
			</table>
			<div id="Sys_UserDialog" class="easyui-dialog" data-options="resizable:true" closed="true" style="width: 760px;height: 380px">
				<div align="center">
				<form id="fm_user" method="get" enctype="multipart/form-data">
					<div style="padding: 10px;width:600px;height: 200px; font-family: sans-serif;" align="center">
						<table>
							<tr align="center">
								<td style="width: 80px; padding: 10px;" align="right" colspan="1">人员ID:</td>
								<td style="padding: 10px;" align="left" colspan="3"><input class="easyui-textbox textbox-f" type="text" id="humanId" name="humanId"/></td>
							</tr>
							<tr align="center" >
								<td style="width: 80px; padding: 10px;"  align="right">标识名:</td>
								<td style="padding: 10px;" align="left"><input class="easyui-textbox textbox-f" type="text" id="username" name="username"/></td>
								<td style="width: 80px; padding: 10px;"  align="right">标识密码:</td>
								<td style="padding: 10px;" align="left"><input class="easyui-textbox textbox-f" type="text" id="password" name="password"/></td>
							</tr>
							<tr align="center">
								<td style="width: 80px; padding: 10px;"  align="right">名字:</td>
								<td style="padding: 10px;" align="left"><input class="easyui-textbox textbox-f" type="text" id="name" name="name"/></td>
								<td style="width: 80px; padding: 10px;"  align="right">性别:</td>
								<td style="padding: 10px;" align="left"><input class="easyui-textbox textbox-f" type="text" id="sex" name="sex"/></td>
							</tr>
							<tr align="center" >
								<td style="width: 80px; padding: 10px;"  align="right">出生日期:</td>
								<td style="padding: 10px;" align="left"><input class="easyui-textbox textbox-f" type="text" id="birthday" name="birthday"/></td>
								<td style="width: 80px; padding: 10px;"  align="right">年龄:</td>
								<td style="padding: 10px;" align="left"><input class="easyui-textbox textbox-f" type="text" id="age" name="age"/></td>
							</tr>
							<tr align="center" >
								<td style="width: 80px; padding: 10px;"  align="right">手机号码:</td>
								<td style="padding: 10px;" align="left"><input class="easyui-textbox textbox-f" type="text" id="phone" name="phone"/></td>
								<td style="width: 80px; padding: 10px;"  align="right">电子邮件:</td>
								<td style="padding: 10px;" align="left"><input class="easyui-textbox textbox-f" type="text" id="email" name="email"/></td>
							</tr>
							<tr >
								<td colspan="4"  style="padding: 10px;" align="center">
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
		</div>
	</div>
<script>
	
	var humanId = null;
	var buttonType = null;
	
	function init(){
		humanId = null;
		buttonType = null;
		$("#fm_user").form("clear");
	}
	
	function addUser(){
		init();
		buttonType = "add";
		$("#humanId").textbox("setValue", getHumanId());
		$("#Sys_UserDialog").dialog("open").dialog("setTitle","增加");
	}
	
	function editUser(){
		init();
		var row = $("#Sys_UserDg").datagrid("getSelected");
		if(row == null){
			alert("请选择修改行！");
			return false;
		}
		buttonType = "edit";
		$("#fm_user").form("load",row);
		$("#Sys_UserDialog").dialog("open").dialog("setTitle","修改");
	}
	
	function deleteUser(){
		init();
		var row = $("#Sys_UserDg").datagrid("getSelected");
		if(row == null){
			alert("请选择修改行！");
			return false;
		}
		$.ajax({
			type : "post",
			url : "../sysManager/deleteByHumanId?humanId=" + row.humanId,
			data : null,
			async : true,
			cache : false,
			success : function(msg) {
				$("#Sys_UserDg").datagrid("reload");
			}
		});
	}
	
	function UserSearch(){
		var searchStr = $("#UserSearch").val();
		if(searchStr == null){
			alert("请填写查询条件！");
			return false;
		}
		console.log(searchStr);
		$.ajax({
			type : "post",
			url : "../sysManager/getSearchUser?searchStr=" + searchStr,
			data : null,
			async : true,
			cache : false,
			success : function(msg) {
				$("#Sys_UserDg").datagrid("reload");
			}
		});
		
	}
	
	function saveurl(){
		var humanId = $("#humanId").val();
		var username = $("#username").val();
		var password = $("#password").val();
		var name = $("#name").val();
		var sex = $("#sex").val();
		var birthday = $("#birthday").val();
		var age = $("#age").val();
		var phone = $("#phone").val();
		var email = $("#email").val();
		
		if(humanId == null){
			humanId = getHumanId();
			$("#humanId").val(humanId);
		}
		
		if(username == null){
			alert("标识名不能为空");
			return false;
		}
		
		if(password == null){
			alert("标识密码不能为空");
			return false;
		}
		
		if(name == null){
			alert("名字不能为空");
			return false;
		}
		
		if(sex == null){
			alert("性别不能为空");
			return false;
		}
		
		if(birthday == null){
			alert("出生日期不能为空");
			return false;
		}
		
		if(age == null){
			alert("年龄不能为空");
			return false;
		}
		
		if(phone == null){
			alert("手机号码不能为空");
			return false;
		}
		
		if(email == null){
			alert("电子邮件不能为空");
			return false;
		}
		console.log(buttonType);
		if(buttonType == "add"){
			$("#fm_user").form('submit',{
				url:"../sysManager/insertUser",
				success:function(data){
					console.log(data);
					$("#Sys_UserDg").datagrid("reload");
				}
			});
		}else {
			$("#fm_user").form('submit',{
				url:"../sysManager/updateUserByHumanId",
				success:function(data){
					console.log(data);
					$("#Sys_UserDg").datagrid("reload");
				}
			});
		}
		
		$("#Sys_UserDialog").dialog("close");
		
	}
	
	function getHumanId(){
		var forward = "33564";
		var center = parseInt(1000000*Math.random());
		var end = parseInt(1000*Math.random());
		return forward + "" + center + "" + end;
	}
	
	$(function(){
		$("#Sys_UserDg").datagrid({
			url:"../sysManager/getAllUser",
			toolbar:"#UserTb",
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
	
	
</script>
</body>
