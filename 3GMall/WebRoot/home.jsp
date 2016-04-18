<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
	<title>主页</title>
</head>

<body>
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
	<img id="recom" src="ima/recommend.png" width="100%" height="353" />
	<div style="overflow:visible;">

		<c:forEach items="${dataList}" var="map" varStatus="status">
			<ul class="item">
				<p class="hh">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${status.index+1}F
					&nbsp;&nbsp;${map['type'].typeName}</p>
			</ul>
			<table cellspacing="30px" style="position:relative;" width="767">
				<tr>

					<c:forEach items="${map['books']}" var="book">
						<td width="166"><a href="showInfo.action?bk=${book.BID}"><img src="${book.face }" /><p>${book.bName}</p></a></td>
					</c:forEach>
				</tr>
			</table>
		</c:forEach>
	</div>

</body>
</html>