<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>
	<div style="position:relative; margin: 0 auto; width: 99%; height: 98.9%; padding-top: 5px; padding-left: 3px;padding-right: 3px; ">
		<div id="planLayout" class="easyui-layout" style="width:100%;height:99%;">
			<div data-options="region:'west'" title="标签页" style="width:20%;">
				<div class="easyui-panel" style="padding:5px;height: 100%" data-options="border:false">
					<div class="easyui-tree" id="noteBookMenu" style="width:100%;height:95%;">
						
					</div>
				</div>
			</div>
			<div data-options="region:'center',split:true,border:false"  style="width:80%;">
				<div id="noteBookShowSpace" class="easyui-panel" style="height: 100%">
					
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/notebook.js"></script>
</body>
