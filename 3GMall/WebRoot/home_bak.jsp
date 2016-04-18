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
	<title>主页</title>
</head>

<body>
	<img id="ad" src="ima/ad.png" width="100%" height="405" />
	<img id="recom" src="ima/recommend.png" width="100%" height="353" />
	<div style="overflow:visible;">
		<c:forEach items="${datalist}" var="map">
			<ul class="item">
				<p class="hh">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1F
					&nbsp;&nbsp;${map[0].typeName}</p>
			</ul>
			<table cellspacing="30px" style="position:relative;" width="767">
				<tr>

					<c:forEach items="${map[1].books}" var="book">
						<td width="166"><img src="ima/b1.png" />${book.bName}</td>
					</c:forEach>
					<!--td width="166"><img src="ima/b2.png" /></td>
                <td width="166"><img src="ima/b3.png" /></td>
                <td width="166"><img src="ima/b4.png" /></td>
                <td width="166"><img src="ima/b5.png" /></td-->
				</tr>
			</table>
		</c:forEach>
		<!-->ul class="item">
		  <p class="hh"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2F &nbsp;&nbsp;文艺</p></ul>
        	<table  cellspacing="30px"style="position:relative;" width="767">
            <tr>
            	<td width="166"><img src="ima/b1.png" /></td>
                <td width="166"><img src="ima/b2.png" /></td>
                <td width="166"><img src="ima/b3.png" /></td>
                <td width="166"><img src="ima/b4.png" /></td>
                <td width="166"><img src="ima/b5.png" /></td>
             </tr>
            </table>
    <ul class="item">
		  <p class="hh"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3F &nbsp;&nbsp;青春</p></ul>
        	<table  cellspacing="30px"style="position:relative;" width="767">
            <tr>
            	<td width="166"><img src="ima/b1.png" /></td>
                <td width="166"><img src="ima/b2.png" /></td>
                <td width="166"><img src="ima/b3.png" /></td>
                <td width="166"><img src="ima/b4.png" /></td>
                <td width="166"><img src="ima/b5.png" /></td>
             </tr>
            </table>
      <ul class="item">
		  <p class="hh"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4F &nbsp;&nbsp;少儿</p></ul>
        	<table  cellspacing="30px"style="position:relative;" width="767">
            <tr>
            	<td width="166"><img src="ima/b1.png" /></td>
                <td width="166"><img src="ima/b2.png" /></td>
                <td width="166"><img src="ima/b3.png" /></td>
                <td width="166"><img src="ima/b4.png" /></td>
                <td width="166"><img src="ima/b5.png" /></td>
             </tr>
            </table>
       <ul class="item">
		  <p class="hh"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5F &nbsp;&nbsp;生活</p></ul>
        	<table  cellspacing="30px"style="position:relative;" width="767">
            <tr>
            	<td width="166"><img src="ima/b1.png" /></td>
                <td width="166"><img src="ima/b2.png" /></td>
                <td width="166"><img src="ima/b3.png" /></td>
                <td width="166"><img src="ima/b4.png" /></td>
                <td width="166"><img src="ima/b5.png" /></td>
             </tr>
            </table>
      <ul class="item">
		  <p class="hh"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6F &nbsp;&nbsp;社科</p></ul>
        	<table  cellspacing="30px"style="position:relative;" width="767">
            <tr>
            	<td width="166"><img src="ima/b1.png" /></td>
                <td width="166"><img src="ima/b2.png" /></td>
                <td width="166"><img src="ima/b3.png" /></td>
                <td width="166"><img src="ima/b4.png" /></td>
                <td width="166"><img src="ima/b5.png" /></td>
             </tr>
            </table>
       <ul class="item">
		  <p class="hh"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7F &nbsp;&nbsp;教育</p></ul>
        	<table  cellspacing="30px"style="position:relative;" width="767">
            <tr>
            	<td width="166"><img src="ima/b1.png" /></td>
                <td width="166"><img src="ima/b2.png" /></td>
                <td width="166"><img src="ima/b3.png" /></td>
                <td width="166"><img src="ima/b4.png" /></td>
                <td width="166"><img src="ima/b5.png" /></td>
             </tr>
            </table>
         <ul class="item">
		  <p class="hh"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;8F &nbsp;&nbsp;工具</p></ul>
        	<table  cellspacing="30px"style="position:relative;" width="767">
            <tr>
            	<td width="166"><img src="ima/b1.png" /></td>
                <td width="166"><img src="ima/b2.png" /></td>
                <td width="166"><img src="ima/b3.png" /></td>
                <td width="166"><img src="ima/b4.png" /></td>
                <td width="166"><img src="ima/b5.png" /></td>
             </tr>
            </table-->
	</div>

</body>
</html>