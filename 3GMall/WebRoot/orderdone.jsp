<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>已完成订单</title>
<style type="text/css">
body, td
{
	font-family: 宋体;
	font-size: 12px;
	text-align: center;
}
.RecAddTable
{
	text-align: center;	
}
</style>
</head>

<body>
<form name="RecAddtitleForm" id="RecAddtitleForm" method="post" action="">
  <div class="">
	<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="21%" align="right" class="">            	
            </td>
			<td>
            	<input type="text" name="search" value="" id="search" style="width:160px;" class="" />
				<a href="" class="" id="searchLink">
            	<span><ins>查询</ins></span></a>&nbsp;
            </td>
		</tr>
	</table>
	</div>
</form>
	<table id="RecAddTable" width="60%" height="70" cellpadding="0" cellspacing="1" class="" align="center">
		<tr class="RecAddTable">
	        <th width="41">选择</th>
	        <th width="*">订单号</th>
	     <th width="73">操作</th> 
        </tr>
       <c:forEach items="${orderlist}" var="order">
        <tr>

        	<td><input type="radio" class="" name="Oid" value="${order.ordid}"/></td>
            <td>${order.ordid}</td>       
	        <td>
            	<s:url id="defray" value="showOrder.action">
            		<s:param name="ooid">${order.ordid}</s:param>
            	</s:url>
            	
            	<s:a href="%{defray}" target="main_frame">查看</s:a>
            	&nbsp
            	<s:url id="delete_order" value="delete_order.action">
            		<s:param name="Oid">${order.ordid}</s:param>
            	</s:url>
            	
            	<s:a href="%{delete_order}">删除</s:a>
            </td>
        </tr>
        </c:forEach> 
	</table>
	<div> <img src="ima/20130911224618.png"/></div>
</body>

</html>