<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div 
	style="position: relative; margin: 0 auto; width: 100%; height: 80%;">
	<div>
		<div style="margin-right: 5px; margin-top: 10px; margin-bottom: 20px;" align="right">
			<a href="#" class="easyui-linkbutton" onclick="newNoteBookPager()"
						iconCls="icon-add" style="height: 25px;">新建</a>
			<a href="#" class="easyui-linkbutton" onclick="newNoteBookContain()"
						iconCls="icon-add" style="height: 25px;">添加</a>
			<a href="#" class="easyui-linkbutton" onclick="loadMenuManager()"
						iconCls="icon-add" style="height: 25px;">菜单管理</a>
		</div>
		<div id="containxxTitle" style="font-size: 20px; text-decoration: none; font-weight: bold; margin-left: 20px; margin-bottom: 30px;"></div>
		<div style="position:relation;display: inline;float: right; margin-right: 20px;">
			<input class="easyui-textbox" id="ContainSearch" style="width:240px; height: 25px;">
			<a href="#" class="easyui-linkbutton" onclick="NoteBookContainSearch()" iconCls="icon-search" style="width:60px;height: 25px;">查找</a>
		</div>
		<div style="margin-left: 40px; margin-right: 10px; margin-top: 60px;" id="containxx">
			
		</div>
	</div>
	<div>
		<div id="newNoteBookPagerDialog" class="easyui-dialog" data-options="resizable:true" closed="true" style="width: 500px;height: 210px" align="center">
			<div style="padding: 10px;width:95%;height: 80%; font-family: sans-serif;">
				<form id="fm_saveNoteBookPager" method="get" enctype="multipart/form-data">
					<table cellpadding="0" cellspacing="0" style="height: 100%;width:100%;border: 1px solid #84c6c3" border="1" >
						<tr align="center">
							<td style="padding: 10px;" align="right">新建页名称:</td>
							<td style="padding: 10px;" align="left"><input class="easyui-textbox textbox-f" style="width: 300px; padding: 10px; height: 30px" type="text" id="newPagerName" name="newPagerName"/></td>
						</tr>
						<tr align="center" >
							<td style="width: 80px; padding: 10px;"  align="right">父菜单:</td>
							<td style="padding: 10px;" align="left">
								<select class="easyui-combobox" style="width: 300px; padding: 10px; height: 30px" type="text" id="F_noteBookCombox" name="F_noteBookCombox">
									
								</select>
							</td>
						</tr>
						<tr >
							<td colspan="2"  style="padding: 10px;" align="center">
								<div>
									<a href="javascript:void(0)" class="easyui-linkbutton" onclick="saveNoteBookPager()" style="width: 80px;margin-right: 20px;">保存</a>
							 		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="cancelNoteBookPager()" style="width: 80px">取消</a>
								</div>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		
	</div>
	
</div>