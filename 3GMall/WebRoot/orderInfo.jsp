<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="cose.seu.entity.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>OrderInfo</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="i.magetoolbar" content="no" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<link href="css/ordering.css" type="text/css" rel="stylesheet">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<div> <img src="ima/dingdanxiangqing.png"> </div>
	<table  style="position: relative; left: 250px;">
		<tr style="height:80px; position: relative; left: -50px; ">
			<th class="th" style="font-weight:bold;">订单号：${ord.ordid }</th>
			<th class="th" style="font-weight:bold;">订单状态：${ord.state }</th>
			
		</tr>
		<tr>
			<th><p>&nbsp;</p></th>
		</tr>
		<tr style="height:25px;">
		 	<th class="th" style="font-size:23px;font-weight:bold;"><p>商品清单</p></th>
			<th class="th" style="font-weight:bold;">${ord.ordDate }</th>
		</tr>
		<tr style="position: relative; ">
			<th class="th" style="width:450px;font-weight:bold;">书名</th>
			<th class="th" style="width:200px;font-weight:bold;">数量</th>
			<th class="th" style="width:200px;font-weight:bold;">单价</th>
		</tr>
		<s:iterator id="item" value="ord.orderItem">
			<tr>
				<th class="th">《${item.book.bName}》</th>
				<th class="th">${item.isbn}</th>
				<th class="th">￥${item.book.price}</th>
			</tr>
		</s:iterator>
			<tr><p>&nbsp;</p></tr>
			<tr style="position: relative; left: 60px;">			
				<th class="th"></th><th class="th"><img src="ima/line3.png"></th>
			</tr>
			<tr style="position: relative; left: 60px;">
				<th class="th" style="position: relative; left: 530px;">支付金额:￥${tol }</th>
			</tr>
	</table>
	<table style="position: relative; left: 250px;">
		<tr>
			<th class="th" style="font-size:23px;font-weight:bold;">收货人信息</th>
		</tr>
		<tr>
		    <th class="th">收货人：${ord.addr.recName }</th>
		    <th class="th">电话/手机：${ord.addr.recPhone }</th>
		</tr>
		<tr>
		    <th class="th">收货地址：${ord.addr.street }</th>
		</tr>
		<tr>
		    <th class="th">运费：${ord.postage }</th>
		</tr>
	</table>
	<a id="back" name="back" href="home.action" target="_top"></a>
</body>
</html>
