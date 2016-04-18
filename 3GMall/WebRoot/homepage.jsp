<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,cose.seu.*" errorPage="" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1"/>
　<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
　　<![endif]-->

<title>3G猫图书交易平台</title>
<script src="js/jquery.js"></script>
<script src="js/log.js"></script>
<script src="js/pop-slider.js"></script>
<link href="css/style.css" type="text/css" rel="stylesheet">
<link href="css/pop-slider.css" type="text/css" rel="stylesheet">
<style type="text/css">


</style>
<SCRIPT language=javascript>
<!--
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
            <a class="slidown" onclick="javascript:showDetail();"><span id="pleaselogin" >请登录&nbsp;&nbsp;</span></a>
            <a href="register.jsp" target="_top"><span id="pleaseregister">免费注册&nbsp;&nbsp;</span></a>
            <!--a href="index.jsp" target="_top"><span id="userpage"><img src="ima/usepage.png" border="0px"></span></a-->
            <a href="showShoppingCart.action" target="view_frame"><span id="shoppingcart">购物车&nbsp;&nbsp;</span></a>
            <!--a href="index.jsp" target="_top"><span id="favorate"><img id="favorate" src="ima/favorate.png" border="0px"></span></a-->
      	</div>
        <div style="height:20px; top:0px; position:relative;">
        	<img id="logo" src="ima/logo.png" />
        	<s:form action="search" method="post" target="view_frame"><input type="text" id="search" name="keyword"/><input type="image" id="searchbutton"  src="ima/searchbutton.png" accesskey="enter"/></s:form>
		</div>
		<div class="typepos">
		<s:form action="type" method="get" onclick="" target="view_frame">
			
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
	<div id="msgDiv">
		<div id="msgShut"><img style="position:relative; left:480;" src="ima/xx.png"></div>
		<div id="msgDetail">
						
					 <s:form action="log" id="in">
   						<p>用户名:<input style="height: 25px; width: 50%; position: relative;left:20px;" type="text" name="username" id="username"/></p>
   						<p style="position: relative;top:10px;">密&nbsp;码:<input style="height: 25px; width: 50%; position: relative;left:29px;" type="password" name="pwd" id="pwd"/></p><a style="position: relative; left: 310px; top:-5px;" href="#">忘记密码</a>
   						<p><input style="position: relative; left:-66px; top: 30px;" type="image" src="ima/loginbutton.png"/></p>
   					 </s:form>
   					 <p><input style="position: relative; left:-15px; top:130px;" type="image" src="ima/registerbutton.png" onclick="window.location.href='register.jsp'"/></p>								
			</div>
		</div>
	</div>
	
 	<iframe id="f2"  style=" position:relative; top:-10px;" onload="this.height=350" src="<s:url action='showItem'/>" name="view_frame" frameborder="0" scrolling="no" width="100%" height="100%"><p>Your browser does not support iframes.</p>
 	</iframe>
    <div class="footer">
    </div>
    <div id="bgDiv" ></div>
</body>
</html>