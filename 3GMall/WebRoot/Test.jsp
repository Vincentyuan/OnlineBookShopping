<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function aaaaa(){
			alert("1111111");
		}
		
		function getHttpReq(){
		var req;
		if(window.XMLHttpRequst){
			req=new XMLHttpRequst();
		}else{
			req=new ActiveXObject("Microsoft.XMLHTTP");
		}
		return req;
		}
	
	function jiaru(){
		var httpreq=getHttpReq();
		alert(httpreq);
		var url="home?SLB="+2;
		alert(url);
		httpreq.open("GET",url,true);
		httpreq.onreadystateChange=function(){
		alert(httpreq.readyState);
			if(httpreq.readyState==4){
			alert(httpreq.status);
				if(httpreq.status==200){
				
					var txt=httpreq.responseText;
					alert(txt);
				}
			}
		};
		httpreq.send(null);
	}
	</script>
  </head>
  
  <body>
	<input type="submit" onclick="aaaaa()" value="点击我"/>
	<input type="submit" onclick="jiaru()" value="发送AJAX请求"/>
	
  </body>
</html>
