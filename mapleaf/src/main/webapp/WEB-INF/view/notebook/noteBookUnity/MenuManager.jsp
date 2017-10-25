<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="float: left; margin: 0 auto; width: 100%; height: 80%;">
	<div style="width: 45%; height:500px; margin-left: 3%; margin-top: 20px;">
		<div id="noteBookMenuManageTb">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="deleteNoteBookMM()" data-options="iconCls:'icon-remove',plain:true">删除</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="editNoteBookMM()" data-options="iconCls:'icon-edit',plain:true">修改</a>
		</div>
		<table id="noteBookMenuManageDg" class="easyui-treegrid" style="height:100%" data-options="singleSelect:true">
			<thead>
				<tr>
					<th data-options="field:'text'" width="50%">text</th>
					<th data-options="field:'id'" width="25%">id</th>
					<th data-options="field:'f_id'" width="25%">f_id</th>
				</tr>
			</thead>
		</table>
	</div>
	<div style="width: 40%;height: 200px;margin-top:-500px; margin-left:55%; border:1px solid #ccc;">
		<form id="fm_editNoteBookManager" method="post" enctype="multipart/form-data">
			<table cellpadding="0" cellspacing="0" style="height: 100%;width:100%;border: 1px solid #84c6c3" border="1" >
				<tr align="center">
					<td style="padding: 10px; " align="right">菜单名称:</td>
					<td style="padding: 10px;" align="left"><input class="easyui-textbox textbox-f" style="width: 300px; padding: 10px; height: 30px" type="text" id="menuMM" name="menuMM"/></td>
				</tr>
				<tr align="center" >
					<td style="width: 60px; padding: 10px;"  align="right">id:</td>
					<td style="padding: 10px;" align="left"><input class="easyui-textbox textbox-f" style="width: 300px; padding: 10px; height: 30px" type="text" id="idMM" name="idMM"/></td>
				</tr>
				<tr align="center" >
					<td style="width: 60px; padding: 10px;"  align="right">f_id:</td>
					<td style="padding: 10px;" align="left"><input class="easyui-textbox textbox-f" style="width: 300px; padding: 10px; height: 30px" type="text" id="f_idMM" name="f_idMM"/></td>
				</tr>
				<tr >
					<td colspan="2"  style="padding: 10px;" align="center">
						<div>
							<a href="javascript:void(0)" class="easyui-linkbutton" id="saveurl" onclick="saveNoteBookMM()" style="width: 80px;margin-right: 20px;">确认修改</a>
						</div>
					</td>
				</tr>
			</table>
		</form>
		<div style="margin-top: 50px;" align="center">
			<a href="javascript:void(0)" class="easyui-linkbutton" style="border:1px solid #ccc;border-radius:3px;" onclick="backShowSpace()" data-options="iconCls:'icon-back',plain:true">返回主页</a>
		</div>
	</div>
<script>
function backShowSpace(){   //返回主题按钮
	$("#noteBookShowSpace").panel({
		href:'../sysManager/getNotebooxShowSpace',
		onLoad:function(){
			loadNoteBookContain();
			$("#containxxTitle").html(ShowText);
		}
	});
}

function deleteNoteBookMM(){ //删除菜单
	var row = $("#noteBookMenuManageDg").datagrid("getSelected");
	if(row == null){
		alert("请选择删除行");
		return false;
	}
	$.ajax({
		type : "post",
		url : "../sysManager/deleteNoteBookMM?id="
				+ row.id,
		data : null,
		async : true,
		cache : false,
		success : function(msg) {
			$("#noteBookMenuManageDg").treegrid("reload");
			loadNoteBookTree();
		}
	});
	
}

function editNoteBookMM(){   //修改按钮
	var row = $("#noteBookMenuManageDg").datagrid("getSelected");
	if(row == null){
		alert("请选择删除行");
		return false;
	}
	console.log("row");
	$("#menuMM").textbox("setValue",row.text);
	$("#idMM").textbox("setValue",row.id);
	$("#f_idMM").textbox("setValue",row.f_id);
}

function saveNoteBookMM(){  //保存修改菜单
	var text = $("#menuMM").val();
	var id = $("#idMM").val();
	var f_id = $("#f_idMM").val();
	if(text == null || text == ""){
		alert("请输入名称");
		return false;
	}
	
	if(id == null || id == ""){
		alert("id不能为空");
		return false;
	}
	
	if(f_id == null || f_id == ""){
		alert("f_id不能为空");
		return false;
	}
	
	$.ajax({
		type : "post",
		url : "../sysManager/EditNoteBookMM?id="
				+ id + "&text=" + text,
		data : null,
		async : true,
		cache : false,
		success : function(msg) {
			$("#noteBookMenuManageDg").treegrid("reload");
			loadNoteBookTree();
			$("#menuMM").textbox("setValue","");
			$("#idMM").textbox("setValue","");
			$("#f_idMM").textbox("setValue","");
		}
	});
}

</script>
</div>