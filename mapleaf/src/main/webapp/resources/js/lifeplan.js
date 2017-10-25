var lifePlan_dh = null;
var buttonType = null;

$(function() {
	loadDiv();
});


function loadDiv() {
	
	if(timesPlanToday == null){
		time = myformatter(new Date());
	}else{
		time = timesPlanToday;
	}
	$.ajax({
		type : "post",
		url : "../sysManager/getLifePlanByTime?time=" + time,
		data : null,
		async : true,
		cache : false,
		success : function(msg) {
			$("#lifePlanbody").children().remove();
			for ( var i in msg) {
				var planBody = "<div class='ml_planList'><span><h3>"
					+ msg[i]['title']
					+ "</h3>"
					+ "</span><hr /><div><div class='ml_planheard'>"
					+ "<span class='ml_planSpan'>"
					+ msg[i]['txTime'] + "</span>"
					+ "<span class='ml_planSpan'>"
					+ msg[i]['yqTime'] + "</span>"
					+ "<span class='ml_planSpan'>" + msg[i]['type']
					+ "</span>" + "<span class='ml_planSpan'>"
					+ msg[i]['step'] + "</span></div>"
					+ "<div class='ml_planDesc'>" + msg[i]['descplan']
					+ "</div>"
					+ "<div class='ml_planfoot' align='right'>"
					+ "<a href='javascript:void(0)' class='easyui-linkbutton "+msg[i]['lifePlan_dh'] +"' id='lifePalnadd' onclick='truelifeplan()' style='width: 80px;margin-right: 10px;'>确定</a>" 
					+ "<a href='javascript:void(0)' class='easyui-linkbutton "+ msg[i]['lifePlan_dh'] + "' id='lifePalncx' onclick='deletelifeplan()' style='width: 80px'>撤销</a>"
					+ "</div></div></div>";
				
				$("#lifePlanbody").append(planBody);
			}
		}
	});
};

function initFm_LifePlan() {
	$("#fm_lifeplan").form("clear");
	var date = new Date();
	var month = date.getMonth() + 1;
	var day = date.getDate();
	if (month < 10)
		month = "0" + month;
	if (day < 10)
		day = "0" + day;
	var today = date.getFullYear() + "-" + month + "-" + day;
	$("#txTime").datebox('setValue', today);
	lifePlan_dh = null;
}

function UserSearch() {
	initFm_LifePlan();
	$("#life_PlanDialog").dialog("open").dialog("setTitle", "添加");
}

function savelifeplan() {

	if (lifePlan_dh == null) {
		lifePlan_dh = getDh();
	}
	var title = $("#title").val();
	var human = $("#human").val();
	var txTime = $("#txTime").datebox("getValue");
	var type_id = $("#type_id").val();
	var yqTime = $("#yqTime").datebox("getValue");
	var step_id = $("#step_id").val();
	var descplan = $("#descplan").val();
	console.log(title + " " + human + " " + txTime + " " + type_id + " "
			+ yqTime + " " + step_id + " " + descplan);
	if (title == null || title == "") {
		alert("标题不能为空！");
		return false;
	}

	if (human == null || human == "") {
		alert("姓名不能为空！");
		return false;
	}

	if (txTime == null || txTime == "") {
		alert("时间不能为空！");
	}

	if (type_id == null || type_id == "") {
		alert("类型不能为空！");
		return false;
	}

	if (yqTime == null || yqTime == "") {
		alert("预期时间不能为空！");
		return false;
	}

	if (step_id == null || step_id == "") {
		alert("等级不能为空！");
		return false;
	}

	if (descplan == null || descplan == "") {
		alert("描述不能为空！");
		return false;
	}

	var day = myformatter(new Date());
	console.log(day.length);
	var month =day.substr(0,7);
	console.log(day + " " + month);
	
	$("#fm_lifeplan").form(
			'submit',
			{
				url : "../sysManager/insertLifePlanBean?lifePlan_dh="
						+ lifePlan_dh + "&title=" + title + "&type_id="
						+ type_id + "&step_id=" + step_id + "&human=" + human
						+ "&txTime=" + txTime + "&yqTime=" + yqTime + "&descplan="
						+ descplan + "&month=" + month + "&day=" + day,
				success : function(data) {
					reloadDiv();
				}
			});
	
	$("#life_PlanDialog").dialog("close");
}

function cancellifeplan() {
	initFm_LifePlan();
	$("#life_PlanDialog").dialog("close");
}

function truelifeplan(){
	var classStr = $("#lifePalnadd").attr("class");
	var lifePlan_dh = classStr.substr(classStr.indexOf(" ")+1,classStr.length);
	console.log(lifePlan_dh);
	$.ajax({
		type : "post",
		url : "../sysManager/updateDealbyLifePlan_dh?lifePlan_dh="
				+ lifePlan_dh,
		data : null,
		async : true,
		cache : false,
		success : function(msg) {
			reloadDiv();
		}
	});
}

function deletelifeplan(){
	var classStr = $("#lifePalncx").attr("class");
	console.log(classStr);
	var lifePlan_dh = classStr.substr(classStr.indexOf(" ")+1,classStr.length);
	$.ajax({
		type : "post",
		url : "../sysManager/deleteLifePlanBeanByLifePlan_dh?lifePlan_dh="
				+ lifePlan_dh,
		data : null,
		async : true,
		cache : false,
		success : function(msg) {
			reloadDiv();
		}
	});
}

function reloadDiv(){
	$("#lifePlanbody").children().remove();
	loadAccordion();
	loadDiv();
}

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

function getDh() {
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
	return "lifepaln" + year + "" + month + "" + day + "" + h + "" + m + "" + s
			+ "_" + parseInt(1000 * Math.random());
}