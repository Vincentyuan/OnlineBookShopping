<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/struts-tags" prefix="s"  %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1"/>
　<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
　　<![endif]-->

<title>3G猫图书交易平台</title>
<script src="js/jquery.js"></script>
<link href="css/style.css" type="text/css" rel="stylesheet">
<SCRIPT language=javascript><!--
function out()
{
if(window.event.toElement.id!="menu" && window.event.toElement.id!="link")
  menu.style.visibility="hidden";
}
//-->

function out1()
{
if(window.event.toElement.id!="menu1" && window.event.toElement.id!="link")
  menu1.style.visibility="hidden";
}
function iFrameHeight() { 
var ifm= document.getElementById("f2"); 
var subWeb = document.frames ? document.frames["view_frame"].document : ifm.contentDocument; 
if(ifm != null && subWeb != null) { 
ifm.height = subWeb.body.scrollHeight; 
} 
}
function reinitIframe(){
var iframe = document.getElementById("f2");
try{
var bHeight = iframe.contentWindow.document.body.scrollHeight;
var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
var height = Math.max(bHeight, dHeight);
iframe.height =  height;
}catch (ex){}
}
window.setInterval("reinitIframe()", 200);

//-->
</SCRIPT>


</head>

<body>
	<div class="head">   
    	<div style="font-size: 1.125em; float:right; color:#ccc; font-weight:500; position:relative; right:100px">欢迎光临!&nbsp;&nbsp;
            <a href="list_upage.action" target="_top"><span id="pleaselogin" >个人主页&nbsp;&nbsp;</span></a>
            <a href="logout.action" target="_top"><span id="pleaseregister">[退出]&nbsp;&nbsp;</span></a>
            <a href="ShoppingCart.jsp" target="view_frame"><span id="shoppingcart">购物车&nbsp;&nbsp;</span></a>
      	</div>
        <div style="height:20px; top:0px; position:relative;">
        	<img id="logo" src="ima/logo.png" />
        	<s:form action="search" method="post" target="view_frame"><input type="text" id="search" name="keyword"/><input type="image" id="searchbutton"  src="ima/searchbutton.png" accesskey="enter"/></s:form>
		</div>
		<div class="typepos">
		<s:form action="type" method="post" onclick="" target="view_frame">
			
				<table>
					<tr id="t" class="typefont">
						<td width="85" height="20"><a href="<s:url action='showItem'/>" target="view_frame"><img src="ima/shouyebutton.png" style="border:0px;" /></a><!--input type="button" class="button1" value="首页"/--></td>
                    	<td width="85"><input type="submit" class="button1" name="keyword" value="小说" /></td>
                    	<td width="85"><input type="submit" class="button1" name="keyword" value="文艺" /></td>
                    	<td width="85"><input type="submit" class="button1" name="keyword" value="青春" /></td>
                    	<td width="85"><input type="submit" class="button1" name="keyword" value="少儿" /></td>
                    	<td width="85"><input type="submit" class="button1" name="keyword" value="生活" /></td>
                    	<td width="85"><input type="submit" class="button1" name="keyword" value="社科" /></td>
                    	<td width="85"><input type="submit" class="button1" name="keyword" value="教育" /></td>
                    	<td width="85"><input type="submit" class="button1" name="keyword" value="工具" /></td>
                	</tr>
                </table>
		</s:form>
		</div>
	</div>
 	<iframe id="f2"  style=" position:relative; top:-10px;" onload="this.height=350" src="<s:url action='showItem'/>" name="view_frame" frameborder="0" scrolling="no" width="100%" height="100%"><p>Your browser does not support iframes.</p>
 	</iframe>
    <div class="footer">
    </div>
</body>
</html>