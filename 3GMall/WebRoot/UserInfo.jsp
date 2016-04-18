<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage="" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
　　<![endif]-->

<title>3G猫图书交易平台</title>
<script src="js/jquery.js"></script>
<link href="css/style.css" type="text/css" rel="stylesheet">
<link href="css/slideshow.css" type="text/css" rel="stylesheet">
	<SCRIPT language=javascript>
	<!--
		function iFrameHeight() {
			var ifm = document.getElementById("userpageleft");
			var subWeb = document.frames ? document.frames["usertrans_frame"].document
					: ifm.contentDocument;
			if (ifm != null && subWeb != null) {
				ifm.height = subWeb.body.scrollHeight;
			}
		}
		function iFrameHeight1() {
			var ifm = document.getElementById("userpageright");
			var subWeb = document.frames ? document.frames["userInfo_frame"].document
					: ifm.contentDocument;
			if (ifm != null && subWeb != null) {
				ifm.height = subWeb.body.scrollHeight;
			}
		}
		function iFrameHeight2() {
			var ifm = document.getElementById("main");
			var subWeb = document.frames ? document.frames["main_frame"].document
					: ifm.contentDocument;
			if (ifm != null && subWeb != null) {
				ifm.height = subWeb.body.scrollHeight;
			}
		}
	//-->
	</SCRIPT>
	<style type="text/css">
#userHead {
	background-image: url(ima/userHead.png);
	background-repeat: no-repeat;
	position: relative;
	height: 65px;
	width: 100%;
	left: -7px;
	top: -35px;
	font-family: "华文楷体";
	font-size: 48px;
	color: #FFF;
}
</style>
</head>


<body>
<div id="userHead"></div>
		
        	<iframe  id="userpageleft" src="usertrans.jsp"
			onload="iFrameHeight()" frameborder=0 name="usertrans_frame"
			scrolling="no" style="position:relative; float:left; "
			width="40%" height="100%"><p>Your browser does not support iframes.</p> 
			</iframe>
          
			<iframe id="userpageright" src="list_binfo.action" onload="iFrameHeight1()"
		frameborder=0 name="userInfo_frame" scrolling="no"
		style="position:relative; float:left;" width="60%"
		height="100%"><p>Your browser does not support iframes.</p>
			</iframe>
			
			
			<div id="ad" style="top:0px;" />  
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
</body>
</html>