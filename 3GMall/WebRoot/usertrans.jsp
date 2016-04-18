<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>
<style type="text/css">
#BasicInfoChange {
	position: relative;
	left: 200px;
	top: 10px;
	width: 204px;
	height: 500px;
	z-index: 1;
	font-family: "方正楷体简体";
	text-align: right;
}

#BasicInfoChange p a {
	font-weight: bold;
	color: #000;
	text-decoration: none;
	font-size: 30px;
}
</style>

<div id="BasicInfoChange" >
  <p><s:a href="list_binfo.action" target="userInfo_frame">基本信息管理</s:a></p>
  <p><a href="list.action" target="userInfo_frame">银行卡管理</a></p>
  <p><a href="list_order.action"target="userInfo_frame">订单查询</a></p>
   <!--<p><a href="RecAdd.jsp" target="userInfo_frame">地址管理</a></p>
  <p><a href="comments.jsp"target="userInfo_frame">评价管理</a></p>  --> 
  <!--<p><a href="index.jsp" target="userInfo_frame">最近浏览</a></p>-->
</div>
</html>