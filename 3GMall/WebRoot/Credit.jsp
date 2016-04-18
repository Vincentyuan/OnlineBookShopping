<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>银行卡管理</title>
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

<body style="height: 800px;">
	<div style="height:auto;">
	 
	      <table width="100%" height="100px" border="0" cellspacing="0" cellpadding="0">
	        <tr>
	          <td width="21%" align="right" class=""></td>
	          <td><input type="text" name="search" value="" id="search" style="width:160px;" class="" />
	            <a href="" class="" id="searchLink2"> <span><ins>查询</ins></span></a>&nbsp; <a href="#" class="button_c" id="showAllLink"><span><ins>显示全部</ins></span></a>&nbsp; <a href="toadd.action"class="button_c" id="addLink"><span><ins>添加</ins></span></a></td>
            </tr>
        </table>
	</div>
</form>
	<table id="RecAddTable" width="70%" height="90" cellpadding="0" cellspacing="1" class="" align="center">
		<thead>
		<tr class="RecAddTable">
	        <th width="41">选择</th>
	        <th width="*">银行卡号</th>
	        <th width="95">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${creditlist}" var="credit">
        <tr>

        	<td><input type="radio" class="" name="CCID" value="${credit.CCID}"/></td>
            <td>${credit.creNumber}</td>       
	        <td>
            	<s:url id="update" value="toedit.action">
            		<s:param name="CCID">${credit.CCID}</s:param>
            	</s:url>
            	
            	<s:a href="%{update}">修改</s:a>
            	&nbsp
            	<s:url id="delete" value="delete.action">
            		<s:param name="CCID">${credit.CCID}</s:param>
            	</s:url>
            	
            	<s:a href="%{delete}">删除</s:a>
            </td>
        </tr>
        </c:forEach> 
        </tbody>
      
	</table>
    <div> <img src="ima/20130911224618.png"/></div>
</body>

</html>