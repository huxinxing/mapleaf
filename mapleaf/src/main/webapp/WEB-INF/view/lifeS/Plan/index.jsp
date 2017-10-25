<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/lifeplan.js"></script>
<div 
	style="position: relative; margin: 0 auto; width: 85%; height: 80%;">
	<div>
		<div style="position: relative;">
			<div
				style="display: block; font-size: 20px; margin-top: 10px; margin-left: 30px">
				<span>计划列表</span>
				<div style="display: inline; float: right; margin-right: 10px"
					align="right">
					<a href="#" class="easyui-linkbutton" onclick="UserSearch()"
						iconCls="icon-add" style="height: 25px;">添加</a>
				</div>
			</div>
			<div
				style="position: relative; margin-top: 10px; margin-right: 10px; margin-bottom: 20px;"
				align="right">
				<input class="easyui-textbox" id="UserSearch"
					style="width: 80% px; height: 25px;"> <a href="#"
					class="easyui-linkbutton" onclick="UserSearch()"
					iconCls="icon-search" style="height: 25px;">搜索</a>
			</div>
		</div>
		<div id="lifePlanbody">
		
		</div>
	</div>
	<div id="life_PlanDialog" class="easyui-dialog" data-options="resizable:true" closed="true" style="width: 1200px;height: 620px">
		<div align="center">
			<form id="fm_lifeplan" method="post" enctype="multipart/form-data">
				<div style="padding: 10px;width:1000px;height: 400px; font-family: sans-serif;" align="center">
					<table cellpadding="0" cellspacing="0" style="height: 96%;border: 1px solid #84c6c3" border="1">
						<tr align="center">
							<td style="width: 80px; padding: 10px;" align="right" colspan="1">标题:</td>
							<td colspan="5" style="padding: 10px;" align="left" colspan="3"><input class="easyui-textbox textbox-f" type="text" id="title" name="title"/></td>
						</tr>
						<tr align="center" >
							<td style="width: 80px; padding: 10px;"  align="right">提报人:</td>
							<td style="padding: 10px;" align="left"><input class="easyui-textbox textbox-f" type="text" id="human" name="human"/></td>
							<td style="width: 80px; padding: 10px;"  align="right">时间:</td>
							<td colspan="3" style="padding: 10px;" align="left"><input class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" type="text" id="txTime" name="txTime"/></td>
						</tr>
						<tr align="center">
							<td style="width: 80px; padding: 10px;"  align="right">类型:</td>
							<td style="padding: 10px;" align="left">
								<select class="easyui-combobox" name="state" style="width:170px;" id="type_id" name="type_id">
									<option value="1">学习</option>
									<option value="2">日常计划</option>
									<option value="3">战略计划</option>
								</select>
							</td>
							<td style="width: 80px; padding: 10px;"  align="right">预计完成时间:</td>
							<td style="padding: 10px;" align="left"><input class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" type="text" id="yqTime" name="yqTime"/></td>
							<td style="width: 80px; padding: 10px;"  align="right">等级:</td>
							<td style="padding: 10px;" align="left">
								<select class="easyui-combobox" name="state" style="width:170px;" id="step_id" name="step_id">
									<option value="1">紧</option>
									<option value="2">较急</option>
									<option value="3">平缓</option>
								</select>
							</td>
						</tr>
						<tr align="center" >
							<td style="width: 80px; padding: 10px;"  align="right">详细描述:</td>
							<td colspan="5" style="padding: 10px;" align="left"><input class="easyui-textbox" style="width: 100%; height:320px; border:0px;text-indent: 20px;" data-options="multiline:true" id="descplan" name="descplan"/></td>
						</tr>
						<tr >
							<td colspan="6"  style="padding: 10px;" align="center">
								<div>
									<a href="javascript:void(0)" class="easyui-linkbutton" id="saveurl" onclick="savelifeplan()" style="width: 80px;margin-right: 20px;">保存</a>
							 		<a href="javascript:void(0)" class="easyui-linkbutton" id="cancelurl" onclick="cancellifeplan()" style="width: 80px">取消</a>
								</div>
							</td>
						</tr>
					</table>
				</div>
			</form>
		</div>
	</div>
</div>
