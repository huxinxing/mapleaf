<%@ include file="../common/Head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
#ml_header {
	border: 1px solid #ccc;
	border-radius: 3px;
	width: 99.8%;
	height: 60px;
	background-color: #2d3e50;
}
#ml_header ul{
	float: right;
	margin-right: 80px;
	margin-top:17px;
}
#ml_header li{
	font-family:serif;
	display: inline;	
	color: white;
	font-size:20px;
	padding-right: 10px;
	padding-left: 10px;
	padding-top: 10px;
	padding-bottom: 15px;
	
}

</style>
<script>
	var windowW = $(window).innerWidth();
	var windowH = $(window).innerHeight() - 80;
	$(function() {
		init();
		loadMeantree("01");
	});
	function init() {
		$("#ml_space").attr("style", "width:100%;height:" + windowH + "px");
		$("#ml_space").layout("resize", {
			width : "99.9%",
			height : windowH + "px"
		});
		loadMean();
		
	}
	function loadMean(){
		$.ajax({
			type : "post",
			url : "../sysManager/loadHeaderMean",
			data : null,
			async : true,
			cache : false,
			success : function(msg) {
				for(var i in msg){
					$("#ml_header ul").append("<li id= '" + msg[i]["id"] + "'>" + msg[i]["text"] + "</li>");
				}
				$("#ml_header li").mousemove(function(){
					$(this).css({
						"text-decoration": "underline",
						"cursor": "pointer"
					});
				});
				$("#ml_header li").mouseout(function(){
					$(this).css({
						"text-decoration": "none",
						"cursor": "none"
					});
				});
				$("#ml_header li").click(function(){
					var id = $(this).attr("id");
					loadMeantree(id);
				});
					 
			},
			error:function(msg){
				console.log("init程序调用失败");
			}
		});
	}
	
	function loadMeantree(id){
		$("#tt").tree({
			url:"../sysManager/loadMenuTree?id=" + id,
			method:"get",
			animate:true,
			onLoadSuccess:function(msg){
				console.log(msg);
			},
			onClick:function(node){
						
				if(!$('#tabs').tabs("exists",node.text)){
					$('#tabs').tabs('add',{
						title: node.text,
						href: node.url,
						closable: true
					});
				}
				
				$('#tabs').tabs('select',node.text);
			}
		});
	}
	
</script>
<body style="padding: 0px;">
	<div id="ml_header">
		<ul>
		</ul>
	</div>
	<div id="ml_space" class="easyui-layout" style="width: 100%; height: 400px;">
		<div data-options="region:'west',title:'West',split:true" style="width: 15%;">
			<div class="easyui-panel" style="padding:5px">
				<ul id="tt" class="easyui-tree"></ul>
			</div>
		</div>
		<div data-options="region:'center'" style=" width: 85%">
			<div id="tabs" class="easyui-tabs" style="width:100%;height:100%;">
			</div>
		</div>
	</div>
</body>
