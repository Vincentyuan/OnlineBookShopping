<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<%@page import="cose.seu.entity.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<html>
<head>
	<title>ordering</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<link href="css/ordering.css" type="text/css" rel="stylesheet">
	<script language="javascript" src="js/hpmenu.js"></script>
</head>

<body>
	<div id="container1">
		<div id="title"></div>
	</div>
	
	<div id="parting1"></div>
	<div id="subtitle1">购买的商品</div>

    <div id="container2">
	    <table id="table">
		    <tr style="height:25px;">
				<th class="th" style="width:400px;font-weight:bold;">书名</th>
				<th class="th" style="width:200px;font-weight:bold;">数量</th>
				<th class="th" style="width:200px;font-weight:bold;">单价</th>
			</tr>
			<s:iterator id="shoppingList" value="shoppingLists">
				<tr>
					<th class="th">《${shoppingList.book.bName}》</th>
					<th class="th">${shoppingList.bnumber}</th>
					<th class="th">￥${shoppingList.book.price}</th>
				</tr>
			</s:iterator>
		</table>
		<div id="parting3"></div>
		<div id="total" name="total">合计：￥${tolPrice}</div>
    </div>

	<form id="container3" action="submit.action">
		<div id="parting2"></div>
		<div id="parting4"></div>
		<div id="subtitle2">收货人信息填写</div>
		<div id="subtitle3">收货人</div>


		<div id="phoneNum">电话</div>
		<div id="reciveName">姓名</div>
		<div id="reciveAddr">地址</div>
		<div id="payment">支付方式</div>
		<div id="invoiceTitle">发票抬头</div>
		
		
		<table id="receiver"> 
		    <tr style="heeight:25px;">
		        <s:iterator id="recs" value="recAddrs" status="st">
		            <s:if test="#st.Index<3">
		        	    <th name="rec1"><input type="radio" name="receiver" value="${recs.recName}" onclick="choose()"/>${recs.recName}</th>
		        	    <th name="rec2" style="display:none;"><input type="radio" name="receiver" onclick="choose()"/>${recs.recPhone}</th>
		        		<th name="rec3" style="display:none;"><input type="radio" name="receiver" onclick="choose()"/>${recs.street}</th>
		        	</s:if>	
		    	</s:iterator>
		    	<th name=rec4><input type="radio" name="receiver" value="add" onclick="choose()"/>新增</th>
		    	<th name=rec5><input type="radio" name="receiver" value="change" onclick="choose()"/>修改</th>
		    </tr>  
		</table>
		
	    <script type="text/javascript">
	        function choose(){
	            for(var i=0;i<3;i++){
	        	    if(document.getElementsByName("receiver")[i*3].checked){
	        			document.getElementById("nameTxt").value=document.getElementsByName("rec1").item(i).innerText
	        			document.getElementById("phoneTxt").value=document.getElementsByName("rec2").item(i).innerText
	        			document.getElementById("detaliedAddr").value=document.getElementsByName("rec3").item(i).innerText
	        			document.getElementById("nameTxt").disabled="disabled"
	        			document.getElementById("phoneTxt").disabled="disabled"
	        			document.getElementById("detaliedAddr").disabled="disabled"
	        			document.getElementById("C").disabled="disabled"
	        		}
	        	}
	        	if(document.getElementsByName("receiver")[9].checked){
	        		document.getElementById("nameTxt").value=""
	        		document.getElementById("phoneTxt").value=""
	        		document.getElementById("detaliedAddr").value=""
	        		document.getElementById("nameTxt").disabled=""
	        		document.getElementById("phoneTxt").disabled=""
	        		document.getElementById("detaliedAddr").disabled=""
	        		document.getElementById("C").disabled=""
	        	}
	        	if(document.getElementsByName("receiver")[10].checked){
	        		document.getElementById("nameTxt").disabled=""
	        		document.getElementById("phoneTxt").disabled=""
	        		document.getElementById("detaliedAddr").disabled=""
	        		document.getElementById("C").disabled=""
	        	}
	        }
	    </script>
		
		<input type="text" id="nameTxt" name="nameTxt"/>
		<input type="text" id="phoneTxt" name="phoneTxt"/>
		
        <div id="address" style="display:inline;">
          <select id="C" style="width:138px;height:42px;font-size: 22px;" onchange="getSubAddr(this, $('P') )"></select>
          <select id="P" style="width:138px;height:42px;font-size: 22px;" onchange="getSubAddr(this, $('Ci') )"><option value="99999999"></option></select>
          <select id="Ci" style="width:138px;height:42px;font-size: 22px;" onchange="getSubAddr(this, $('T') )"><option value="99999999"></option></select>
          <select id="T"  style="width:138px;height:42px;font-size: 22px;" onchange="$('SelValue').innerText = toSelValue()"><option value="99999999"></option></select>
          <p><font color=red><strong id="SelValue" ></strong></font></p>
          <script> mm.value=addr</script>
      </div>
		
		<textarea id="detaliedAddr" name="detaliedAddr"></textarea>
		<select id="paymentWay" name="paymentWay">
			<option value="" selected></option>
			<option value="在线支付">在线支付</option>
			<option value="货到付款">货到付款</option>
		</select>
		<input type="text" id="invoiceTxt" name="invoiceTxt"/>
		<input id="submit" name="submit" type="submit" value=""/>
		<input id="giveUp" name="giveUp" type="button" value"" onclick="showItem.action" />
	</form>
	
</body>
</html>