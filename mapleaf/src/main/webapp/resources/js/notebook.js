
var ShowText = "mysql_常规操作";
var ShowId = "00101";
var containdh = null;

/*
 * 初始化主界面
 */
$(function(){
	$("#noteBookShowSpace").panel({
		href:'../sysManager/getNotebooxShowSpace',
		onLoad:function(){
			loadNoteBookTree();
			loadNoteBookContain();
			$("#containxxTitle").html(ShowText);
		}
	});
})

function loadNoteBookContain(){
	$.ajax({
		type : "post",
		url : "../sysManager/nNBloadNbTextListdg?id=" + ShowId,
		data : null,
		async : true,
		cache : false,
		success : function(msg) {
			$("#containxx").children().remove();
			for(var i in msg){
				var num = i - 0 + 1;
				var contain = "<div style='margin-bottom:50px;'><h3>"+num+"."+msg[i]["containTitle"]+"</h3><hr/><span style='display:block;margin-bottom:5px;' align='right'>"+msg[i]["timeEdit"]+"</span><div style='margin-left: 20px;text-indent:20px;'>"+msg[i]["containText"]+"</div></div>";
				$("#containxx").append(contain);
			}
		}
	});
}

function loadNoteBookTree(){   //加载树形菜单
	$("#noteBookMenu").tree({
		url:"../sysManager/getNoteBookTree",
		method:"post",
		animate:true,
		onLoadSuccess:function(msg){
			console.log(msg);
		},
		onClick:function(node){
			if(node.children.length == 0){
				ShowText = node.text;
				ShowId = node.id;
				getContainbyId();
				loadNoteBookContain();
				$("#containxxTitle").html(ShowText);
			}
		}
	});
}

function getContainbyId(){  //树形菜单点击事件
	
	
	$("#nbtextlistdg").datagrid({
		url:"../sysManager/nNBloadNbTextListdg?id=" + ShowId,
		rownumbers:true,
		onLoadSuccess:function(){
		}
	});
	
	$("#caption").html(ShowText);
	
	
	
}


/*
 * 添加新的笔记主题界面
 * 
*/
function newNoteBookPager(){
	$("#fm_saveNoteBookPager").form("clear");
	$("#newNoteBookPagerDialog").dialog("open").dialog("setTitle", "新建页");
	loadNoteBookCombox();
}

function loadNoteBookCombox(){  //加载新建页父菜单选项
	$("#F_noteBookCombox").combobox({
		url:"../sysManager/getNoteBookCombox",
		method:"post",
		valueField:"id",
		textField:"text"
	});
}

function saveNoteBookPager(){  //新主题 保存按钮
	
	var newPagerName = $("#newPagerName").val();
	var F_noteBookCombox = $("#F_noteBookCombox").combobox("getValue");
	
	if(newPagerName == null || newPagerName == ""){
		alert("名称不能为空");
		return false;
	}
	
	if(F_noteBookCombox == null || F_noteBookCombox == ""){
		alert("父菜单不能为空");
		return false;
	}
	
	console.log(newPagerName + "  " + F_noteBookCombox);
	
	$("#fm_saveNoteBookPager").form('submit',{
		url : "../sysManager/addNoteBooxNewMenu",
		success : function(data) {	
			loadNoteBookTree();
			loadNoteBookCombox();
		}
	});
	
	$("#newNoteBookPagerDialog").dialog("close");
}

function cancelNoteBookPager(){   //新主题  关闭dialog界面
	$("#newNoteBookPagerDialog").dialog("close");
}

/*
 * 新建笔记内容，由原界面中的添加作为入口 NNB
 */
function newNoteBookContain(){   //跳转菜单管理界面
	$("#noteBookShowSpace").panel({
		href:'../sysManager/goNewNoteBookPagers',
		onLoad:function(){
			loadNbtextlistdg();
			$("#caption").html(ShowText);
			$("#id").textbox("setValue",ShowId);
			$("#NewNoteBokPagerTime").datebox("setValue",myformatter(new Date()));
		}
	});
}

function loadNbtextlistdg(){
	$("#nbtextlistdg").datagrid({
		url:"../sysManager/nNBloadNbTextListdg?id=" + ShowId,
		rownumbers:true,
		onClickRow:function(rowIndex,rowData){
			containdh = rowData.containdh;
			$("#fm_saveNoteBookPager").form("load",rowData);
		}
	});
}

/*
 * 
 * 菜单管理界面MenuManager->MM
 * 
 */
function loadMenuManager(){  //菜单管理的主界面
	$("#noteBookShowSpace").panel({
		href:'../sysManager/goMenuManager',
		onLoad:function(){
			loadNoteBookMenuManageDg();
		}
	});
}

function loadNoteBookMenuManageDg(){  //树形网格->菜单管理界面加载树形菜单
	$("#noteBookMenuManageDg").treegrid({
		url:"../sysManager/getNoteBookTree",
		toolbar:"#noteBookMenuManageTb",
		rownumbers:true,
		method: 'get',
		idField: 'id',
		treeField: 'text'
	});
}

/*
 * 查询
 */
function NoteBookContainSearch(){
	var search = $("#ContainSearch").val();
	$.ajax({
		type : "post",
		url : "../sysManager/nNBloadNbTextListdgearch?id=" + ShowId + "&search=" + search,
		data : null,
		async : true,
		cache : false,
		success : function(msg) {
			$("#containxx").children().remove();
			for(var i in msg){
				var num = i - 0 + 1;
				var contain = "<div style='margin-bottom:50px;'><h3>"+num+"."+msg[i]["containTitle"]+"</h3><hr/><span style='display:block;margin-bottom:5px;' align='right'>"+msg[i]["timeEdit"]+"</span><div style='margin-left: 20px;text-indent:20px;'>"+msg[i]["containText"]+"</div></div>";
				$("#containxx").append(contain);
			}
		}
	});
}

/*
 * 公共函数库
 */
function myformatter(date) {
	var y = date.getFullYear();
	var m = date.getMonth() + 1;
	var d = date.getDate();
	return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);
}
function myparser(s) {
	if (!s)
		return new Date();
	var ss = (s.split('-'));
	var y = parseInt(ss[0], 10);
	var m = parseInt(ss[1], 10);
	var d = parseInt(ss[2], 10);
	if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
		return new Date(y, m - 1, d);
	} else {
		return new Date();
	}
}