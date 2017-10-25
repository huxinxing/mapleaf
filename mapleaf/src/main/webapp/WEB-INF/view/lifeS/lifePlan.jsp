<%@ include file="../common/Head.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.ml_planList{
		margin-bottom: 20px;
		border: 1px solid #ccc; 
		border-radius: 3px;
		margin: 5px; 
		padding-left: 30px; 
		padding-right: 10px;
	}
	.ml_planSpan{
		margin-right: 8px;
		cursor: pointer;
	}
	.ml_planSpanButton{
	
		margin-right: 8px;
		cursor: pointer;
	}
	.ml_planDesc{
		font-size: 15px;
		text-indent: 20px;
		cursor: pointer;
	}
	.ml_planheard{
		margin-top: 10px;
		margin-bottom: 15px;
		cursor: pointer;
	}
	.ml_planfoot{
		margin-bottom:10px;
		cursor: pointer;
	}
</style>

<body>
	<div style="position:relative; margin: 0 auto; width: 99%; height: 99%; padding-top: 5px; padding-left: 3px;padding-right: 3px; border:1px solid #ccc; border-radius:1px; ">
		<div id="planLayout" class="easyui-layout" style="width:100%;height:100%;">
			<div data-options="region:'west'" title="时间轴" style="width:20%;">
				<div class="easyui-panel" style="padding:5px;height: 100%" data-options="border:false">
					<div class="easyui-tree" id="accordionMenu" style="width:100%;height:95%;">
						
					</div>
				</div>
			</div>
			<div data-options="region:'center',split:true,border:false"  style="width:80%;">
				<div id="planShowSpace" class="easyui-panel" style="height: 100%">
				</div>
			</div>
		</div>
	</div>
	
<script>

var timesPlanToday = null;

$(function(){
	$("#planShowSpace").panel({
		href:'../sysManager/goPlanIndex'
	});
	loadAccordion();
	
});

function loadAccordion(){
	
	$("#accordionMenu").tree({
		url:"../sysManager/getAccordionMenu",
		method:"post",
		animate:true,
		onLoadSuccess:function(msg){
		},
		onClick:function(node){
			if((node.id).length >7){
				sssss = node.id;
				$("#planShowSpace").panel({
					href:'../sysManager/goPlanIndex'
				});
			}
		}
	});
	
}
</script>
</body>
