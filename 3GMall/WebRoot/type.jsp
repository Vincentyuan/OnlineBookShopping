<%@page import="cose.seu.entity.UserInfo"%>
<%@page import="cose.seu.entity.Book"%>
<%@page import="org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut"%>
<%@page import="cose.seu.test.bookDaoTest"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,cose.seu.*,javax.servlet.http.*,com.opensymphony.xwork2.ActionSupport,org.apache.struts2.ServletActionContext" errorPage="" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="css/style.css" type="text/css" rel="stylesheet">
<link href="css/slideshow.css" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<%
HttpSession s = ServletActionContext.getRequest().getSession(true);
UserInfo us=(UserInfo) s.getAttribute("user"); 
Long i =0l;
if(us!=null)i=us.getUID();
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
	
	function jiaru(name){
		var bookid=document.getElementById(name).innerHTML;
		var httpreq=getHttpReq();
		var url="add.action?SLB="+bookid;
		httpreq.open("GET",url,true);
		httpreq.onreadystateChange=function(){
			if(httpreq.readyState==4){
				if(httpreq.status==200){
					var txt=httpreq.responseText;
					alert(txt);
				}
			}
		};
		httpreq.send(null);
	}
	
			function jiarushoucang(name){
		var bookid=document.getElementById(name).innerHTML;
		var httpreq=getHttpReq();
		var url="addtofav.action?SLB="+bookid;
		httpreq.open("GET",url,true);
		httpreq.onreadystateChange=function(){
			if(httpreq.readyState==4){
				if(httpreq.status==200){
					var txt=httpreq.responseText;
					alert(txt);
				}
			}
		};
		httpreq.send(null);
	}
	
	function gou(p){
var u = <%=i%>;
if(u==0)javascript:showDetail();
else
	jiaru(p);


}

function shou(q){
var u = <%=i%>;
if(u==0)javascript:showDetail();
else
	jiarushoucang(q);


}

function showDetail() { 
//背景
  var bgObj=window.parent.document.getElementById("bgDiv");
  alert("请登录");
  bgObj.style.width = "100%";
  bgObj.style.height = "3900px";
//定义窗口
  var msgObj=window.parent.document.getElementById("msgDiv");
  msgObj.style.marginTop = -75 +  document.documentElement.scrollTop + "px";
//关闭
  window.parent.document.getElementById("msgShut").onclick = function(){
  bgObj.style.display = msgObj.style.display = "none";
  }
  msgObj.style.display = bgObj.style.display = "block";
}
	</script>
</head>

<body>
	<div style="background:#666; width:100%; height:40px; top:0px;">
		<a href="showItem.action" target="view_frame"><p style=" position:relative; left:30px; top:3px; color:#FFF; font:'仿宋'; font-size:1.5em; float:left;">主页</p></a><p style=" position:relative; left:30px; top:3px; color:#FFF; float:left; font:'仿宋'; font-size:1.5em;">&gt;${keyword}</p>
	</div>
	<div id="ad" />  
		<div id="yc-mod-slider">
        	<div class="wrapper">
            	<div id="slideshow" class="box_skitter fn-clear">
                	<ul>
                   		<li>
                        	<img alt="Joomla模板与内容的融合设计" class="cubeRandom" src="ima/slider1.jpg" /></li>
                    	<li>
                        	<img alt="野草工作室一直在用心建站" class="cubeRandom" src="ima/slider2.jpg" /></li>
                    	<li>
                        	<img alt="利用Joomla+SEO提升网络营销竞争力" class="cubeRandom" src="ima/slider3.jpg" /></li>
                	</ul>
            	</div>
            	<script type="text/javascript" src="js/slideshow.js"></script>
        	</div>
    	</div>
    </div>
	<c:forEach items="${books}" var="book" varStatus="status">
	<ul style="position:relative; top:20px; left:-15px;">
		
			<table width="1013">
    			<tr>
    				<td width="231">
    					
                    	<a href="showInfo.action?bk=${book.BID}" target="view_frame">
                    	<p style="visibility: hidden;" id="${status.index}">${book.BID}</p>
                    	<p><img src="${book.face}" width="146" height="196"/></p>
  						<p>&nbsp;</p>
  						<p>《${book.bName}》
 						 </p></a>
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
   						<p>	<input type="image" src="ima/jiarushoucangjia.png" width="101" height="93"  onclick="shou('${status.index}')"/>
                        	<input style="position:relative; left:30px;" type="image" src="ima/jiarugouwuche.png" width="101" height="93" onclick="gou('${status.index}')"/></p>
					</td>
   					<td width="79">
     					<img style="position:relative; left:40px;" src="ima/shuxian.png" width="21" height="221" />
                    </td>
     				<td width="379">简介   
     :${book.summary}
     				</td>
  				</tr>
  			</table>
  		
	</ul>
	
	</c:forEach>
</body>
</html>