<%@page import="org.apache.struts2.ServletActionContext"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,javax.servlet.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="struts" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="css/SC.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>购物车</title>
<style type="text/css"></style>
<% if(request.getAttribute("SC")==null)
{
	response.sendRedirect("showShoppingCart.action");
}
int  i =0;
%>

<script type="text/javascript" language=javascript>
	
	function getHttpReq(){
		var req;
		if(window.XMLHttpRequst){
			req=new XMLHttpRequst();
		}else{
			req=new ActiveXObject("Microsoft.XMLHTTP");
		}
		return req;
	}
	
	function increase(num,p,s) {
		//var bookid=document.getElementById("bookid").innerHTML;
		var bbid=document.getElementById("bookid").innerHTML;
	
		var httpreq=getHttpReq();
		var n = document.getElementById(num).value;
		//var url="sumaction.action?SLB="+bbid+"&Num="+n;
		var price = document.getElementById(p).value;
		var tp;
		
		tp=parseFloat(price)*parseInt(n);
		tp="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;￥"+tp.toFixed(2);
		document.getElementById(s).innerHTML=tp;
		//alert(url);
		/*httpreq.open("GET",url,true);
		httpreq.onreadystateChange=function(){
			if(httpreq.readyState==4){
				alert(httpreq.status);
				if(httpreq.status==200){
					var txt=httpreq.responseText;
					alert(tp);
					document.getElementById("SC_price").value=tp;
				}
			}
		};
		httpreq.send(null);*/
	}
	
	
	
	
	</script>
</head>
<body>

<div class="SC_title" id="SC_title"></div>

<form action="settleAccount.action" method="post">
	
	
<c:forEach items="${SCBook}" var="sl" varStatus="status">
		<div  id="bookid" style="visibility: hidden;">${sl.BID}</div>
		<div id="id" style="visibility: hidden;">${status.index}</div>
		<div id="${sl.bName}" style="visibility: hidden;" value="${sl.price}"></div>
		<div class="ShoppingList" id="ShoppingList">
        <table width="900"  height="92" border="0"> 
        	<tr> 
   		    <td width="87"><input type="checkbox" name="checkbox" id="checkbox" value="${sl.bName}"/></td>
          	<td width="500"><a href="index.jsp" style="text-decoration:none;color:#000" id="SC_text" border="0px" >${sl.bName}</a></td>
			<td width="34"><input type="button" style="border:0" name="SC_reduce" id="SC_reduce" size="" value="" onclick='if (document.getElementById("${sl.BID}").value>1){document.getElementById("${sl.BID}").value--;}' /></td>
            <td width="45"><input id="${sl.BID}" name="${sl.bName}" type="text" value="1" size="4" onpropertychange="javascript:increase('${sl.BID }','${sl.bName}','${status.index}');"/></td>
            <td width="34"><input type="button"  style="border:0" name="SC_increase" id="SC_increase" value="" onclick='document.getElementById("${sl.BID}").value++' /></td>
    		<td width="200" id="${status.index}" style="color:#000; " name="SC_price">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;￥${sl.price}</td>
            <td width="50"><a style="border-color: #ffffff; border: none; position:relative; left: 120px;" href="sldel.action?slid=${sl.BID}"><img style="border: 0px;" src="ima/del.png" /></a></td></tr>
        </table>
	  	</div>
	  	</c:forEach>

  		
        
		<div class="SC_buttomd" id="SC_buttomd">
        <table id=SC_buttomtable border="0"> <tr> <td width="48%-447px"></td>
        <td width="100px"><input type="submit" style="border:0" name="SC_pay" id="SC_pay"  value="" onclick="window.location.href='settleAccount.action'"/></td> 
        <td width="6%"></td>
        <td width="149px"></td> 
        <td width="6%"></td>
        <td width="100px"><input name="SC_compare" type="button" id="SC_compare" style="border:0" value="" onclick="window.location.href='showItem.action'"/></td>
        <td width="40%"></td>
        </tr> </table>
        
      </div> 	
      </form>

</body>
</html>