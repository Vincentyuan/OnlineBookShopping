<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.sql.*,java.io.*,java.awt.Image,java.awt.image.*,com.sun.image.codec.jpeg.*,java.sql.*,com.jspsmart.upload.*,java.util.*,java.io.FileInputStream,java.io.FileOutputStream,java.awt.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="js/myjs.js" charset="UTF-8"></script>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>基本信息修改</title>
<style type="text/css">
body{font-size:12px;font-family:Verdana,Arial,"宋体";}
a:link {color:#464646;text-decoration:none;}
a:visited {color:#464646;text-decoration:none;}
a:hover{color:#ed145b;text-decoration:underline;}
a:active{color:#ed145b;text-decoration:underline;}
td{font-size:12px}
/*/*/
/*DateCSS样式*/
.header {font: 12px Arial, Tahoma !important;font-weight: bold !important;font: 11px Arial, Tahoma;font-weight: bold;color: #154BA0;background:#C2DEED;height: 25px;padding-left: 10px;
}
.header td {padding-left: 10px;}
.header a {color: #154BA0;}
.header input {background:none;vertical-align: middle;height: 16px;}
.category {font: 12px Arial, Tahoma !important;font: 11px Arial, Tahoma;color: #92A05A;height:20px;background-color: #FFFFD9;}
.category td {border-bottom: 1px solid #DEDEB8;}
.expire, .expire a:link, .expire a:visited {color: #999999;}
.default, .default a:link, .default a:visited {color: #000000;}
.checked, .checked a:link, .checked a:visited {color: #FF0000;}
.today, .today a:link, .today a:visited {color: #00BB00;}
#calendar_year {display: none;line-height: 130%;background: #FFFFFF;position: absolute;z-index: 10;}
#calendar_year .col {float: left;background: #FFFFFF;margin-left: 1px;border: 1px solid #86B9D6;padding: 4px;}
#calendar_month {display: none;background: #FFFFFF;line-height: 130%;border: 1px solid #86B9D6;padding: 4px;position: absolute;z-index: 11;}
.tableborder {background: white;border: 1px solid #86B9D6;}
#year,#month{padding-right:10px;}
</style>
<style type="text/css">
.BasicInfoEditTitle{
	font-family: "华文楷体";
	font-size: 18px;
	color: #000;
	position: relative;
	left: -50px;
	top: 0px;
}
.title{
	font-family: "华文楷体";
	font-size: 30px;
	color: #000;
	font-weight: bold;
}
</style>
<script language="javascript">
//页面日期输入日历控件
var ie =navigator.appName=="Microsoft Internet Explorer"?true:false;
function $(objID){
return document.getElementById(objID);
}
</script>
</head>
<body>


<script type="text/javascript">
var controlid = null;
var currdate = null;
var startdate = null;
var enddate  = null;
var yy = null;
var mm = null;
var hh = null;
var ii = null;
var currday = null;
var addtime = false;
var today = new Date();
var lastcheckedyear = false;
var lastcheckedmonth = false;
function _cancelBubble(event) {
e = event ? event : window.event ;
if(ie) {
 e.cancelBubble = true;
} else {
 e.stopPropagation();
}
}
function getposition(obj) {
 var r = new Array();
 r['x'] = obj.offsetLeft;
 r['y'] = obj.offsetTop;
 while(obj = obj.offsetParent) {
 r['x'] += obj.offsetLeft;
 r['y'] += obj.offsetTop;
 }
 return r;
}
function loadcalendar() {
s = '';
s += '<div id="calendar" style="display:none; position:absolute; z-index:9;" onclick="_cancelBubble(event)">';
if (ie)
{
s += '<iframe width="200" height="160" src="about:blank" style="position: absolute;z-index:-1;"></iframe>';
}
s += '<div style="width: 200px;"><table class="tableborder" cellspacing="0" cellpadding="0" width="100%" style="text-align: center">';
///
s += '<tr align="center" class="header"><td class="header"><a href="#" onclick="refreshcalendar(yy, mm-1);return false" title="上一月"><<</a></td><td colspan="5" style="text-align: center" class="header"><a href="#" onclick="showdiv(\'year\');_cancelBubble(event);return false" title="点击选择年份" id="year"></a>  -  <a id="month" title="点击选择月份" href="#" onclick="showdiv(\'month\');_cancelBubble(event);return false"></a></td><td class="header"><A href="#" onclick="refreshcalendar(yy, mm+1);return false" title="下一月">>></A></td></tr>';
s += '<tr class="category"><td>日</td><td>一</td><td>二</td><td>三</td><td>四</td><td>五</td><td>六</td></tr>';
for(var i = 0; i < 6; i++) {
s += '<tr class="altbg2">';
for(var j = 1; j <= 7; j++)
s += "<td id=d" + (i * 7 + j) + " height=\"19\">0</td>";
s += "</tr>";
}
s += '<tr id="hourminute"><td colspan="7" align="center"><input type="text" size="1" value="" id="hour" onKeyUp=\'this.value=this.value > 23 ? 23 : zerofill(this.value);controlid.value=controlid.value.replace(/\\d+(\:\\d+)/ig, this.value+"$1")\'> 点 <input type="text" size="1" value="" id="minute" onKeyUp=\'this.value=this.value > 59 ? 59 : zerofill(this.value);controlid.value=controlid.value.replace(/(\\d+\:)\\d+/ig, "$1"+this.value)\'> 分</td></tr>';
s += '</table></div></div>';///
s += '<div id="calendar_year" onclick="_cancelBubble(event)"><div class="col">';
for(var k = 1930; k <= 2019; k++) {
s += k != 1930 && k % 10 == 0 ? '</div><div class="col">' : '';
s += '<a href="#" onclick="refreshcalendar(' + k + ', mm);$(\'calendar_year\').style.display=\'none\';return false"><span' + (today.getFullYear() == k ? ' class="today"' : '') + ' id="calendar_year_' + k + '">' + k + '</span></a><br />';
}
s += '</div></div>';
s += '<div id="calendar_month" onclick="_cancelBubble(event)">';
for(var k = 1; k <= 12; k++) {
s += '<a href="#" onclick="refreshcalendar(yy, ' + (k - 1) + ');$(\'calendar_month\').style.display=\'none\';return false"><span' + (today.getMonth()+1 == k ? ' class="today"' : '') + ' id="calendar_month_' + k + '">' + k + ( k < 10 ? ' ' : '') + ' 月</span></a><br />';
}
s += '</div>';
var nElement = document.createElement("div");
nElement.innerHTML=s;
document.getElementsByTagName("body")[0].appendChild(nElement);
//document.write(s);
document.onclick = function(event) {
$('calendar').style.display = 'none';
$('calendar_year').style.display = 'none';
$('calendar_month').style.display = 'none';
}
$('calendar').onclick = function(event) {
_cancelBubble(event);
$('calendar_year').style.display = 'none';
$('calendar_month').style.display = 'none';
}
}
function parsedate(s) {
/(\d+)\-(\d+)\-(\d+)\s*(\d*):?(\d*)/.exec(s);
var m1 = (RegExp.$1 && RegExp.$1 > 1899 && RegExp.$1 < 2101) ? parseFloat(RegExp.$1) : today.getFullYear();
var m2 = (RegExp.$2 && (RegExp.$2 > 0 && RegExp.$2 < 13)) ? parseFloat(RegExp.$2) : today.getMonth() + 1;
var m3 = (RegExp.$3 && (RegExp.$3 > 0 && RegExp.$3 < 32)) ? parseFloat(RegExp.$3) : today.getDate();
var m4 = (RegExp.$4 && (RegExp.$4 > -1 && RegExp.$4 < 24)) ? parseFloat(RegExp.$4) : 0;
var m5 = (RegExp.$5 && (RegExp.$5 > -1 && RegExp.$5 < 60)) ? parseFloat(RegExp.$5) : 0;
/(\d+)\-(\d+)\-(\d+)\s*(\d*):?(\d*)/.exec("0000-00-00 00\:00");
return new Date(m1, m2 - 1, m3, m4, m5);
}
function settime(d) {
$('calendar').style.display = 'none';
controlid.value = yy + "-" + zerofill(mm + 1) + "-" + zerofill(d) + (addtime ? ' ' + zerofill($('hour').value) + ':' + zerofill($('minute').value) : '');
}
function showcalendar(event, controlid1, addtime1, startdate1, enddate1) {
controlid = controlid1;
addtime = addtime1;
startdate = startdate1 ? parsedate(startdate1) : false;
enddate = enddate1 ? parsedate(enddate1) : false;
currday = controlid.value ? parsedate(controlid.value) : today;
hh = currday.getHours();
ii = currday.getMinutes();
var p = getposition(controlid);
$('calendar').style.display = 'block';
$('calendar').style.left = p['x']+'px';
$('calendar').style.top = (p['y'] + 20)+'px';
_cancelBubble(event);
refreshcalendar(currday.getFullYear(), currday.getMonth());
if(lastcheckedyear != false) {
$('calendar_year_' + lastcheckedyear).className = 'default';
$('calendar_year_' + today.getFullYear()).className = 'today';
}
if(lastcheckedmonth != false) {
$('calendar_month_' + lastcheckedmonth).className = 'default';
$('calendar_month_' + (today.getMonth() + 1)).className = 'today';
}
$('calendar_year_' + currday.getFullYear()).className = 'checked';
$('calendar_month_' + (currday.getMonth() + 1)).className = 'checked';
$('hourminute').style.display = addtime ? '' : 'none';
lastcheckedyear = currday.getFullYear();
lastcheckedmonth = currday.getMonth() + 1;
}
function refreshcalendar(y, m) {
var x = new Date(y, m, 1);
var mv = x.getDay();
var d = x.getDate();
var dd = null;
yy = x.getFullYear();
mm = x.getMonth();
$("year").innerHTML = yy;
$("month").innerHTML = mm + 1 > 9  ? (mm + 1) : '0' + (mm + 1);
for(var i = 1; i <= mv; i++) {
 dd = $("d" + i);
 dd.innerHTML = " ";
 dd.className = "";
}
while(x.getMonth() == mm) {
 dd = $("d" + (d + mv));
 dd.innerHTML = '<a href="###" onclick="settime(' + d + ');return false">' + d + '</a>';
 if(x.getTime() < today.getTime() || (enddate && x.getTime() > enddate.getTime()) || (startdate && x.getTime() < startdate.getTime())) {
 dd.className = 'expire';
} else {
 dd.className = 'default';
}
if(x.getFullYear() == today.getFullYear() && x.getMonth() == today.getMonth() && x.getDate() == today.getDate()) {
 dd.className = 'today';
 dd.firstChild.title = '今天';
}
if(x.getFullYear() == currday.getFullYear() && x.getMonth() == currday.getMonth() && x.getDate() == currday.getDate()) {
dd.className = 'checked';
}
x.setDate(++d);
}
while(d + mv <= 42) {
 dd = $("d" + (d + mv));
 dd.innerHTML = " ";
 d++;
}
if(addtime) {
$('hour').value = zerofill(hh);
$('minute').value = zerofill(ii);
}
}
function showdiv(id) {
var p = getposition($(id));
$('calendar_' + id).style.left = p['x']+'px';
$('calendar_' + id).style.top = (p['y'] + 16)+'px';
$('calendar_' + id).style.display = 'block';
}
function zerofill(s) {
var s = parseFloat(s.toString().replace(/(^[\s0]+)|(\s+$)/g, ''));
s = isNaN(s) ? 0 : s;
return (s < 10 ? '0' : '') + s.toString();
}
loadcalendar();
//-----------------------------------------------------------------------------------------
//头像上传即时预览js
//function upload(){
//var xmlhttp;
//if (window.XMLHttpRequest)
 // {// code for IE7+, Firefox, Chrome, Opera, Safari
 // xmlhttp=new XMLHttpRequest();
 // }
//else
 // {// code for IE6, IE5
 // xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
 // }
  //xmlhttp.onreadystatechange=function(){
  function upload(){
  	var docObj=document.getElementById("doc");
	var imgObjPreview=document.getElementById("preview");
	if(docObj.files && docObj.files[0]){
	//火狐下，直接设img属性
	imgObjPreview.style.display = 'block';
	imgObjPreview.style.width = '100px';
	imgObjPreview.style.height = '100px';
	//imgObjPreview.src = docObj.files[0].getAsDataURL();
	//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
	imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
	}else{
	//IE下，使用滤镜
	docObj.select();
	var imgSrc = document.selection.createRange().text;
	var localImagId = document.getElementById("localImag");
	//必须设置初始大小
	localImagId.style.width = "100px";
	localImagId.style.height = "100px";
	//图片异常的捕捉，防止用户修改后缀来伪造图片
	try{
	localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
	localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
	}catch(e){
	alert("您上传的图片格式不正确，请重新选择!");
	return false;
	}
	imgObjPreview.style.display = 'none';
	document.selection.empty();
	}
	return true; 
  
  }
//xmlhttp.open("post","uploadimage.action",true);
//xmlhttp.send();
//}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------

function checkpwd(){
  if(document.getElementById("pwd").value.toString()==document.getElementById("pwdagain").value.toString()){
    if(strlen(document.getElementById("pwd").value)<6||str(document.getElementById("pwd").value)>16){
      alert("\密码长度仅可为6-16位合法字符！");
    }else if(strlen2(document.getElementById("pwd").value)){
      alert("\密码中包含了非法字符！");
    }else return true;
  }else{
    alert("\两次输入密码不一致，请重新输入！");
  } 
}
function strlen(str){
var len;
var i;
len=0;
for(i=0;i<str.length;i++){
if(str.charCodeAt(i)>255)
	len+=2;
	else len++;
}
return len;
}

function strlen2(str){
var i;
for(i=0;i<str.length;i++){
if(str.charCodeAt(i)>255)
	return true;
}
return false;
}
//---------------------------------------------------------------------------------------
function checkphone(){
if(strlen(document.getElementById("phone").value)!=11)
alert("请输入11位手机号码，否则更改失败！");
}
//---------------------------------------------------------------------------------------
function checkmail(){
if(document.getElementById("mail").value.contains("@"))
return true;
else
alert("请输入正确格式电子邮箱，否则修改无效！");
}
//---------------------------------------------------------------------------------------
function checkanswer(){
if(strlen(document.getElementById("answer").value)<2||strlen(document.getElementById("answer").value)>30)
alert("请输入规定长度的答案！");
}
</script>

<s:form action="update_binfo" method="post" enctype="multipart/form-data">
	<table class="BasicInfoEditTitle" style="width:670px;" align="center">
		<caption></caption>
	<tr><td colspan="2" class="title">基本信息修改</td></tr>
	<tr>
    	<th>当前密码</th>
    		<td>
        
            	<input size="50" name="opwd" type="password"
                   value="${opwd}" readonly />
        
    		</td>
	</tr>
	<tr>
    	<th>&nbsp;&nbsp;新密码</th>
    	<td>
        
            <input size="50" id="pwd" name="pwd" type="password" />
        	<div class="explanation-msg">密码长度6～16位，字母区分大小写。如果不填写，表示不修改密码。</div>
    	</td>
	</tr>
	<tr>
    	<th>新密码确认</th>
    	<td colspan="2">
        
            <input size="50" id="pwdagain" name="pwdagain" type="password" onblur="checkpwd()"/>
        
    	</td>
	</tr>
	<tr>
    	<th>昵称*</th>
    	<td>
        
            <input size="50" name='nname' type="text" value="${nname}" onchange="checknname()"/>
    	</td>
	</tr>
	<tr>
    	<th>手机*</th>
    	<td>
            <input size="50" id="phone" name="phone" type="text" value="${phone}" onblur="checkphone()"/>          
         	<div>登录可用</div>       
    	</td>
	</tr>
	<tr>
    	<th>电子邮件*</th>
    	<td>        
            <input size="50" id="mail" name="mail" type="text" value="${mail}" onblur="checkmail()"/>
        	<div >用于系统中信息的接收。</div>
    	</td>
	</tr>
	<tr>
    	<th>密码提示问题*</th>
 		<td>
        	<span id="selectGroupSpan">
                <select id="attributes'question'" name="question"><option value="我就读的第一所学校的名称？">我就读的第一所学校的名称？</option><option value="我最喜欢的休闲运动是什么？">我最喜欢的休闲运动是什么？</option><option value="我最喜欢的运动员是谁？">我最喜欢的运动员是谁？</option><option value="我最喜欢的物品的名称？">我最喜欢的物品的名称？</option><option value="我最喜欢的歌曲？">我最喜欢的歌曲？</option><option value="我最喜欢的食物？">我最喜欢的食物？</option><option value="我最爱的人的名字？">我最爱的人的名字？</option><option value="我最爱的电影？">我最爱的电影？</option><option value="我妈妈的生日？">我妈妈的生日？</option></select>
       		</span>
       			<input type="hidden" name="question" value="select"/>
        
    	</td>
	</tr>
	<tr>
    	<th>您的答案*</th>
    	<td>        
            <input size="50" id="answer" name='answer' type="text"
                   value="${answer}" onblur="checkanswer()"/>
        <div>答案长度2～30位，字母区分大小写，在忘记密码时根据问题及答案修改密码。</div>
    	</td>
	</tr>
	<tr>
    	<th>出生日期*</th>
    		<td>
         		<input name="birth" onkeydown="(this,1)" type="text"
         		 readonly onclick="showcalendar(envent,this);" onfocus="showcalendar(event, this);if(this.value=='0000-00-00')this.value=''"
                value="<s:date name="birth" format="yyyy-MM-dd" />"/>
        		<div>用于修复帐号密码，请填写您的真实生日，日期输入格式如2008-10-01，也可以通过日期控件选择</div>
   			</td>
	</tr>


	<tr>
    	<th>性别</th>
    	<td>
            <select name="gender">
                <option value="男" selected='selected'>男</option>
                <option value="女">女</option>
            </select>
    	</td>
	</tr>
	<tr>
    	<th>头像</th>
    	<td height="45" align="center" valign="middle"><!--<form action="uploadimage.action" method="post" enctype="multipart/form-data" >   -->
		<p><div id="localImag"><img id="preview" width=-1 height=-1 style="diplay:none" /></div></p> 
		<input id="doc" type="file" name="image" onchange="upload()">
		
		</td> 
    <!--<td>
    <div><img id="userFace" src="ima/hobby1.png" alt="个人头像" onload="setSize(this,64,64);" /></div>
        
            <input size="50" id="userFaceField" name='user.Head' type="hidden"
                   value=''>
        <input type="button" onclick="addAttach();" value="上传头像"/><div>上传的头像必须小于100k，格式为jpg,gif,jpeg,png等</div>
    </td>  -->
	</tr>



	<tr height="200">
  		<td colspan="2" style="text-align:center;">
    		<input type="submit" value="保 存" "/>&nbsp;&nbsp;&nbsp;<input type="button" value="返 回" onclick="location.href='list_binfo.action'"/>
  		</td>
	</tr>

    
   </table>
</s:form>

</body>


</html>