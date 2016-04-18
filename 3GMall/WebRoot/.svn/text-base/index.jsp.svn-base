<%@ page language="java" import="java.util.*,cose.seu.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body id="bod">
    This is my JSP page. <br>
     <s:form action="search">
    	<s:textfield name = "keyword"></s:textfield>
    	<s:submit value="搜索"></s:submit>
    </s:form>
    <c:forEach items="${books}" var="book">
	<ul style="position:relative; top:20px; left:-15px;">
		<form action="" >
			<table width="1013">
    			<tr>
    				<td width="231">
    					
                    	<a href="<s:url action="showInfo.action?"/>" >
                        <p><img src="ima/b2.png" width="146" height="196"/></p>
  						<p>&nbsp;</p>
  						<p>《${book.bName}</p></a>
  					</td>
  					<td width="304"><p>价格: ${book.price}</p>
    					<p>&nbsp;</p>
   						<p>&nbsp;</p>
   						<p>作者: ${book.author}</p>
    					<p>&nbsp;</p>
    					<p>&nbsp;</p>
    					<p>出版社: ${book.publisher}</p>
    					<p>&nbsp;</p>
    					<p>&nbsp;</p>    
   						<p>	<input type="image" src="ima/jiarushoucangjia.png" width="101" height="93"/>
                        	<input style="position:relative; left:30px;" type="image" src="ima/jiarugouwuche.png" width="101" height="93"/></p>
					</td>
   					<td width="79">
     					<img style="position:relative; left:40px;" src="ima/shuxian.png" width="21" height="221" />
                    </td>
     				<td width="379">简介   
     :${book.summary}
     				</td>
  				</tr>
  			</table>
  		</form>
	</ul>
	
	</c:forEach>
  </body>
</html>
