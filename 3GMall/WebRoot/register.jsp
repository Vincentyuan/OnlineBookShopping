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
<link href="css/style.css" type="text/css" rel="stylesheet">
<style type="text/css">


</style>

  </head>
  
  <body>
  <div class="head">   
        <div style="height:20px; top:30px; position:relative;">
        	<img id="logo" src="ima/logo.png" />
		</div>
		
	</div>
	<div><img src="ima/zhucebiaoti.png" /></div>
	<s:form action="RegisterAction" id="zhuceinput">
   		<p>用户名&nbsp;:<input style="height: 25px; width: 150%; position: relative;left:30px;" type="text" name="username" id="username"/></p>
   		<p style="position: relative;top:10px;">昵&nbsp;&nbsp;称:<input style="height: 25px; width: 150%; position: relative;left:29px;" type="text" name="nickname" id="pwd"/></p>
   		<p style="position: relative;top:20px;">密&nbsp;&nbsp;码:<input style="height: 25px; width: 150%; position: relative;left:29px;" type="password" name="pwd" id="spwd"/></p>
   		<p style="position: relative;top:30px;">确认密码:<input style="height: 25px; width: 150%; position: relative;left:29px;" type="password" name="spwd" id="nickname"/></p>   		
   		<p><input style="position: relative; left:0px; top: 90px;" type="image" src="ima/zb.png"/></p>
   	</s:form>
   	<p>
   	  <input style="position: relative; left:640px; top:61px;" type="image" src="ima/fb.png" onclick="window.location.href='home.action'"/>
   	</p>								
  </body>
</html>
