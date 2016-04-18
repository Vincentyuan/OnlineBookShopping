<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,cose.seu.*,javax.servlet.http.*,com.opensymphony.xwork2.ActionSupport,org.apache.struts2.ServletActionContext" errorPage="" pageEncoding="utf-8"%>
<script language="javascript" type="">

function countDown(secs){

 tiao.innerText=secs;

 if(--secs>0)

  setTimeout("countDown("+secs+")",1000);

 }

 countDown(3);

</script>
<body>
<p></p>
<span id="tiao"><p>${re}</p><p>3</span><a href="javascript:countDown"></a>秒后自动跳转……</p><meta http-equiv=refresh content=3;url='showItem.action'/></ul>
</body>