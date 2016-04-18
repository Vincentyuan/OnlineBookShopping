<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
#title {
	background-image: url(ima/itemback.png);
	background-repeat: no-repeat;
	height: 75px;
	color: #FFF;
	font-family: "仿宋";
	font-size: 36px;
	font-weight: 500;	
	}
</style>
<title>收藏夹</title>
</head>
<body> 
<div id="title"><p style="position:relative;border:0; left:10px;">收藏夹</p></div>
<c:forEach items="${fav}" var="pfav">
<ul style="position:relative; top:20px; left:-15px;">
			<table width="1013">
    			<tr>
    				<td width="231">
    					
                    	<a href="showInfo.action?bk=${pfav.book.BID}" target="main_frame">
                    	<p><img src="${pfav.book.face}" width="146" height="196"/></p>
  						<p>&nbsp;</p>
  						<p>《${pfav.book.bName}》
 						 </p></a>
  					</td>
  					<td width="304"><p>价格: ${pfav.book.price}</p>
    					<p>&nbsp;</p>
   						<p>&nbsp;</p>
   						<p>作者: ${pfav.book.author}</p>
    					<p>&nbsp;</p>
    					<p>&nbsp;</p>
    					<p>出版社: ${pfav.book.publisher}</p>
    					<p>&nbsp;</p>
    					<p>&nbsp;</p>    
   						<p>&nbsp;</p>
					</td>
   					<td width="79">
     					<img style="position:relative; left:40px;" src="ima/shuxian.png" width="21" height="221" />
                    </td>
     				<td width="379">简介   :${pfav.book.summary}
     				</td>
  				</tr>
  			</table>
  			<input type="button" onclick="window.location.href='fdel.action?fid=${pfav.FID}'">
	</ul>
</c:forEach>
</body>
</html>