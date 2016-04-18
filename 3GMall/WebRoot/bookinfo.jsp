<%@page import="cose.seu.entity.UserInfo"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,cose.seu.*,javax.servlet.http.*,com.opensymphony.xwork2.ActionSupport,org.apache.struts2.ServletActionContext" errorPage="" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1"/>
　<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
　　<![endif]-->

<title>3G猫图书交易平台</title>
<script src="js/jquery.js"></script>
<link href="css/style.css" type="text/css" rel="stylesheet"/>
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
	
	function comments(na){
	var b=document.getElementById("bd").value;
	var c=document.getElementById("co").value;
	var url="com.action?bk="+b+"&comm='"+c+"'";
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
	
	function jiaru(){
		var bookid=document.getElementById("bookid").innerHTML;
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
	
		function jiarushoucang(){
		var bookid=document.getElementById("bookid").innerHTML;
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

function ord(){
var u = <%=i%>;
var n = document.getElementById("num").value;
var b = document.getElementById("book").value;
if(u==0)javascript:showDetail();
else
	window.location.href="load.action?bid="+b+"&bookNumber="+n;


}
function gou(){
var u = <%=i%>;
var n = document.getElementById("num").value;
var b = document.getElementById("book").value;
if(u==0)javascript:showDetail();
else
	jiaru();


}

function shou(){
var u = <%=i%>;
var n = document.getElementById("num").value;
var b = document.getElementById("book").value;
alert(u);
alert(n);
alert(b);
if(u==0)javascript:showDetail();
else
	jiarushoucang();


}
	</script>
	
</head>

<body>
	<div>
		
        	<table width="920">
            	<tr>
                	<td width="312">
                    	<img src="${bok.face}" width="216" height="295" />
                    </td>
                    <td width="596">
                    <p style="visibility: hidden;" id="bookid">${bok.BID}</p>
                    <p>${bok.bName}</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>价格:￥${bok.price} &nbsp;&nbsp;&nbsp;折扣:9.5折 </p>
                    <p>&nbsp;</p>
                    <p>顾客评分:90&nbsp;&nbsp;&nbsp; 已有251本售出</p>
                    <p>&nbsp;</p>
                    <hr />
                    <p>&nbsp;</p>
                    <p>作 者:${bok.author}</p>
                    <p>&nbsp;</p>
                    <p>出版社:${bok.publisher}</p>
                    <p>&nbsp;</p>
                    <p>出版时间:${bok.pTime}</p>
                    <p>&nbsp;</p>
                    <p>简介:</p>
                    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${bok.summary}</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <!--form action="load.action"-->
                    <p>我要买:<input id="num" style="width:30px;" type="text" name="bookNumber"  value="1"/>本</p>
                    <p>&nbsp;</p><input id="book" style="visibility: hidden;" name="bid" value="${bok.BID }" />
                    <p><input name="" type="image" src="ima/goumaoi.png" width="101" height="93" onclick="javascript:ord()" />
                    <!--/form-->
                    <input onclick="gou()" id="jiarugouwuche" style="position:relative; left:20px; top:0px; " type="image" src="ima/jiarugouwuche.png"/>
                    <input style="position:relative; left:40px; top:0px;" type="image" src="ima/jiarushoucangjia.png" onclick="shou()" />
                    </p>
                    </td>
                </tr>
            </table>
		
	</div>
    <div>
      <p><img src="ima/tongleituijian.png" width="100%" /></p>
    	
    </div>
<div style="background:url(ima/yonghupingjia.png); background-repeat:no-repeat; height:50px;"><p class="hh">&nbsp;&nbsp;用户评价</p>
    	
    </div>
    <div class="f">
    	<table width="863">
        		<tr>
            		<form action="com.action">
            			<input id="bd" style="visibility: hidden;" name="bk" value="${bok.BID}"/>
            			<input id="co" type="text" name="comm" style="position: relative;width: 1000px;height: 100px; color: #faeeee; font-size: 24px;" value="写下您的评价:"/>
            			<input type="image" src="ima/com.png" />
            		</form>
            	</tr>
        	<s:iterator id="" value="bok.comments" status="s">        	
        		<tr id="#s.getIndex">
        		   	<td valign="top" width="623">${Comments}</td>
                	<td width="35">
                		<img src="ima/shuxian.png" />
                	</td>
                	<td width="189">
                		<p><img height="80px;" width="80px;" src="ima/${User.head}"/></p>
                		<p>用户名:${User.userName}</p>
                	</td>
          		</tr>
            	</s:iterator>
            	
          </table>
</div>
<hr />
<div id="msgDiv">
		<div id="msgShut"><img style="position:relative; left:480;" src="ima/xx.png"></div>
		<div id="msgDetail">
						
					 <s:form action="log" id="in">
   						<p>用户名:<input style="height: 25px; width: 50%; position: relative;left:20px;" type="text" name="username" id="username"/></p>
   						<p style="position: relative;top:10px;">密&nbsp;码:<input style="height: 25px; width: 50%; position: relative;left:29px;" type="password" name="pwd" id="pwd"/></p><a style="position: relative; left: 310px; top:-5px;" href="#">忘记密码</a>
   						<p><input style="position: relative; left:-66px; top: 30px;" type="image" src="ima/loginbutton.png"/></p>
   					 </s:form>
   					 <p><input style="position: relative; left:-15px; top:130px;" type="image" src="ima/registerbutton.png" onclick="window.location.href='register.jsp'"/></p>								
			</div>
		</div>
	</div>
	<div id="bgDiv" ></div>
</body>
</html>