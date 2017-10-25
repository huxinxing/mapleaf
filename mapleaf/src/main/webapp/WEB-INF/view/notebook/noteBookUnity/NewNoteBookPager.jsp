<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div style="float: left; margin: 0 auto; width: 100%; height: 98%; padding-top: 5px;">
	<div class="" style="width: 97%; min-height: 99%; margin-left: 2%;">
		<div style="float:left; ;padding: 5px;width:60%;height: 99%; font-family: sans-serif;">
				<form id="fm_saveNoteBookPager" method="get" enctype="multipart/form-data">
					<table cellpadding="0" cellspacing="0" style="height: 100% ;width:100%;border: 1px solid #84c6c3" border="1" >
						<caption style="text-align: left; font-size: 16px; font-weight: bold;" id="caption">
						标签
						</caption>
						<tr align="center">
							<td style="padding: 10px;" align="right">containdh:</td>
							<td style="padding: 10px;" align="left"><input class="easyui-textbox textbox-f" style="width: 150px; padding: 10px; height: 30px" type="text" id="containdh" name="containdh" readonly="readonly"/></td>
							<td style="padding: 10px;" align="right">id:</td>
							<td style="padding: 10px;" align="left"><input class="easyui-textbox textbox-f" style="width: 150px; padding: 10px; height: 30px" type="text" id="id" name="id" readonly="readonly"/></td>
						</tr>
						<tr align="center">
							<td style="padding: 10px;" align="right">标题:</td>
							<td style="padding: 10px;" align="left" colspan="3"><input class="easyui-textbox textbox-f" style="width: 300px; padding: 10px; height: 30px" type="text" id="NewNoteBokPagerTitle" name="containTitle"/></td>
						</tr>
						<tr align="center" >
							<td style="width: 80px; padding: 10px;"  align="right">时间:</td>
							<td style="padding: 10px;" align="left" colspan="3"><input class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" style="width: 300px; padding: 10px; height: 30px" type="text" id="NewNoteBokPagerTime" name="timeEdit"/></td>
						</tr>
							<td style="padding: 10px;" align="right">内容:</td>
							<td style="padding: 10px;" align="left" colspan="3">
								<input class="easyui-textbox" data-options="multiline:true" value="" style="width:100%;height:250px" id="NewNoteBokPagerContain" name="containText">
							</td>
						<tr>
						</tr>
						<tr >
							<td colspan="4"  style="padding: 10px;" align="center">
								<div>
									<a href="javascript:void(0)" class="easyui-linkbutton" onclick="saveNoteBookPagerTh()" style="width: 80px;margin-right: 20px;">保存</a>
									<a href="javascript:void(0)" class="easyui-linkbutton" onclick="editNoteBookPagerTh()" style="width: 80px;margin-right: 20px;">修改</a>
									<a href="javascript:void(0)" class="easyui-linkbutton" onclick="deleteNoteBookPagerTh()" style="width: 80px;margin-right: 20px;">删除</a>
								</div>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div style="float: left; width: 30%;min-height: 200px; margin-left: 8%;margin-top: 30px;">
				<table id="nbtextlistdg" class="easyui-datagrid" style=" width: 100%;height: 400px;" data-options="singleSelect:true">
					<thead>
						<tr>
							<th data-options="field:'containTitle'" width="200%">内容</th>
						</tr>
					</thead>
				</table>
				<div align="center" style="margin-top: 40px;">
					<a href="javascript:void(0)" class="easyui-linkbutton" style="border:1px solid #ccc;border-radius:3px;margin-right: 20px;" onclick="backShowSpaceTh()" data-options="iconCls:'icon-back',plain:true">返回主页</a>
				</div>
			</div>
	</div>
<script>
	
	
	
	function backShowSpaceTh(){
		$("#noteBookShowSpace").panel({
			href:'../sysManager/getNotebooxShowSpace',
			onLoad:function(){
				NoteBokPagerEditor = null;
				loadNoteBookTree();
				loadNoteBookCombox();
				loadNoteBookContain();
				$("#containxxTitle").html(ShowText);
			}
		});
	}
	
	function saveNoteBookPagerTh(){
		var containdh = getDhContain();
		
		$("#containdh").textbox("setValue",containdh);
		
		var NewNoteBokPagerTitle = $("#NewNoteBokPagerTitle").val();
		var NewNoteBokPagerTime = $("#NewNoteBokPagerTime").datebox("getValue");
		var NewNoteBokPagerContain = $("#NewNoteBokPagerContain").val();
		
		if(NewNoteBokPagerTitle == null || NewNoteBokPagerTitle == ""){
			alert("标题不能为空！");
			return false;
		}
		
		if(NewNoteBokPagerTime == null || NewNoteBokPagerTime == ""){
			alert("时间不能为空！");
			return false;
		}
		
		if(NewNoteBokPagerContain == null || NewNoteBokPagerContain == ""){
			alert("内容不能为空！");
			return false;
		}
		
		if(containdh == null || containdh == ""){
			alert("单号不能为空！");
			return false;
		}
		var num = 0;
		$("#fm_saveNoteBookPager").form('submit',{
			url:"../sysManager/insertNoteBookContain",
			success:function(data){
				if(num++ == 0){
					$("#nbtextlistdg").datagrid("reload");
					$("#fm_saveNoteBookPager").form("clear");
					$("#id").textbox("setValue",ShowId);
					$("#NewNoteBokPagerTime").datebox("setValue",myformatter(new Date()));
					containdh = null;
				}
			}
		});
		
	}
	
	function editNoteBookPagerTh(){
		var NewNoteBokPagerTitle = $("#NewNoteBokPagerTitle").val();
		var NewNoteBokPagerTime = $("#NewNoteBokPagerTime").datebox("getValue");
		var NewNoteBokPagerContain = $("#NewNoteBokPagerContain").val();
		
		if(NewNoteBokPagerTitle == null || NewNoteBokPagerTitle == ""){
			alert("标题不能为空！");
			return false;
		}
		
		if(NewNoteBokPagerTime == null || NewNoteBokPagerTime == ""){
			alert("时间不能为空！");
			return false;
		}
		
		if(NewNoteBokPagerContain == null || NewNoteBokPagerContain == ""){
			alert("内容不能为空！");
			return false;
		}
		var num = 0;
		$("#fm_saveNoteBookPager").form('submit',{
			url:"../sysManager/editNoteBookPagerTh",
			success:function(data){
				if(num++ == 0){
					$("#nbtextlistdg").datagrid("reload");
					$("#fm_saveNoteBookPager").form("clear");
					$("#id").textbox("setValue",ShowId);
					$("#NewNoteBokPagerTime").datebox("setValue",myformatter(new Date()));
					containdh = null;
				}
			}
		});
	}
	
	function deleteNoteBookPagerTh(){
		var NewNoteBokPagerTitle = $("#NewNoteBokPagerTitle").val();
		var NewNoteBokPagerTime = $("#NewNoteBokPagerTime").datebox("getValue");
		var NewNoteBokPagerContain = $("#NewNoteBokPagerContain").val();
		
		if(NewNoteBokPagerTitle == null || NewNoteBokPagerTitle == ""){
			alert("标题不能为空！");
			return false;
		}
		
		if(NewNoteBokPagerTime == null || NewNoteBokPagerTime == ""){
			alert("时间不能为空！");
			return false;
		}
		
		if(NewNoteBokPagerContain == null || NewNoteBokPagerContain == ""){
			alert("内容不能为空！");
			return false;
		}
		var num = 0;
		$("#fm_saveNoteBookPager").form('submit',{
			url:"../sysManager/deleteNoteBookPagerTh",
			success:function(data){
				if(num++ == 0){
					$("#nbtextlistdg").datagrid("reload");
					$("#fm_saveNoteBookPager").form("clear");
					$("#id").textbox("setValue",ShowId);
					$("#NewNoteBokPagerTime").datebox("setValue",myformatter(new Date()));
					containdh = null;
				}
			}
		});
	}
	
	function getDhContain() {
		var myDate = new Date();
		var year = myDate.getFullYear();
		var month = myDate.getMonth();
		var day = myDate.getDay();
		var h = myDate.getHours();
		var m = myDate.getMinutes();
		var s = myDate.getSeconds();
		if (month < 10)
			month = "0" + month;
		if (day < 10)
			day = "0" + day;
		if (h < 10)
			h = "0" + h;
		if (m < 10)
			m = "0" + m;
		if (s < 10)
			s = "0" + s;
		return "contain" + year + "" + month + "" + day + "" + h + "" + m + "" + s
				+ "_" + parseInt(1000 * Math.random());
	}
	
</script>	
</div>