<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>基本信息展示</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <style type="text/css">
  #Infotitle {
	position: raletive;
	left: 0px;
	top: 0px;
	width: auto;
	height: auto;
	z-index: 1;
	font-family: "微软雅黑";
	font-size: 28px;
	color: #000;
}
  #hobby1 {
	position: relative;
	left: 175px;
	top: -55px;
	width: auto;
	height: auto;
	z-index: 1;
}
  #hobby2 {
	position: relative;
	left: 260px;
	top: -125px;
	width: auto;
	height: auto;
	z-index: 1;
}
  #hobby3 {
	position: relative;
	left: 345px;
	top: -195px;
	width: auto;
	height: auto;
	z-index: 1;
}
 #editbutton {
	position: relative;
	left: 505px;
	top: 0px;
	width: auto;
	height: auto;
	z-index: 1;
}
  </style>
  </head>
  <div id="Infotitle">
   <p>昵称：<s:property value="nname"></s:property></p>
   <p>性别：<s:property value="gender"></s:property></p>
   <p>年龄：<s:property value="age"></s:property></p>
   <p>生日：<s:date name="birth" format="dd/MM/yyyy" /></p>
   <p>电话：<s:property value="phone"></s:property></p>
   <p>邮箱：<s:property value="mail"></s:property></p>
   </div>
    <!--<p>我喜欢的：</p>
  
  <div id="hobby1" ><img src="ima/hobby1.png" width="74" height="70"></div>
  <div id="hobby2" ><img src="ima/hobby1.png" width="74" height="70"></div>
  <div id="hobby3" ><img src="ima/hobby1.png" width="74" height="70"></div>
      -->
  
  <div id="editbutton" >
  <s:url id="edit_binfo" value="edit_binfo.action">   
  </s:url>
  <s:a href="%{edit_binfo}"><img src="ima/BasicInfoUpdate.png" width="122" height="70"></s:a></div>
  </html>
