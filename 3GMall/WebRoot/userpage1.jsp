<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage="" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
　　<![endif]-->

<title>3G猫图书交易平台</title>
<link href="css/style.css" type="text/css" rel="stylesheet">
<SCRIPT language=javascript>
function iFrameHeight() { 
var ifm= document.getElementById("main"); 
var subWeb = document.frames ? document.frames["main_frame"].document : ifm.contentDocument; 
if(ifm != null && subWeb != null) { 
ifm.height = subWeb.body.scrollHeight; 
} 
}
function reinitIframe(){
var iframe = document.getElementById("main");
try{
var bHeight = iframe.contentWindow.document.body.scrollHeight;
var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
var height = Math.max(bHeight, dHeight);
iframe.height =  height;
}catch (ex){}
}
window.setInterval("reinitIframe()", 200);

</SCRIPT>
	<style type="text/css">
#userHead {
	background-image: url(ima/userHead.png);
	background-repeat: no-repeat;
	position: relative;
	height: 65px;
	width: 100%;
	left: -7px;
	top: -6px;
	font-family: "华文楷体";
	font-size: 48px;
	color: #FFF;
}
</style>
</head>

<body>

	<div class="head">

		<div style="font-size: 1.125em; float:right; color:#ccc; font-weight:500; position:relative; top:10px; right:100px">欢迎光临!&nbsp;&nbsp;
            <a href="logout.action" target="_top"><span id="shoppingcart">[退出]&nbsp;&nbsp;</span></a>
            <a href="showfav.action" target="main_frame"><span id="pleaseregister">收藏夹&nbsp;&nbsp;</span></a>
            <a href="ShoppingCart.jsp" target="main_frame"><span id="shoppingcart">购物车&nbsp;&nbsp;</span></a>
            <a href="home.action" target="_top"><span id="shoppingcart">首页&nbsp;&nbsp;</span></a>
      	</div>
        <div style="height:20px; top:0px; position:relative;">
        	<img id="logo" src="ima/logo.png"  />
       	  <div style=" font:'仿宋'; font-size:18px; width:175px; position:relative; left:0px; float:right; top:25px;" method="post" target="view_frame">
        	  <h3 style="position: relative;right:150px; top: 60px;">你好,<s:property value="nname"></s:property> </h3>
        	  <input style="position: relative; top: -20px; height: 100px;width: 100px;" height="300" id="head" type="image" src="ima/${head}" accesskey="enter"/></div>
		</div>

	</div>
	 <iframe onload="iFrameHeight()" id="main" name="main_frame" src="UserInfo.jsp" width="100%"
            height="100%" style="position:relative; top:0px;" frameborder="0" scrolling="no">
	 </iframe>
        
	
	<div class="footer"></div>

</body>
</html>