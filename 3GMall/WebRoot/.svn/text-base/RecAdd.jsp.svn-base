<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>收件人地址管理</title>
	<style type="text/css">
body,td {
	font-family: 宋体;
	font-size: 12px;
	text-align: center;
}

.RecAddTable {
	text-align: center;
}
</style>
	<script language="javascript" src="js/hpmenu.js"></script>
</head>

<body>
	<form name="RecAddtitleForm" id="RecAddtitleForm" method="post"
		action="">
		<div class="">
			<table width="100%"  border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td width="21%" align="right" class=""></td>
					<td><input type="text" name="search" value="" id="search"
						style="width:160px;" class="" /> <a href="" class=""
						id="searchLink"> <span><img src="" /> <ins>查询</ins> </span> </a>&nbsp;
						<a href="#" class="button_c" id="showAllLink"><span><ins>显示全部</ins>
						</span> </a>&nbsp; <a href="#" class="button_c" id="addLink"><span><ins>添加</ins>
						</span> </a> <a href="#" class="button_c" id="deleteLink"><span><ins>删除</ins>
						</span> </a></td>
				</tr>
			</table>
		</div>
	</form>
	<table id="RecAddTable" width="100%"  cellpadding="0"
		cellspacing="1" class="" align="center" height="120">
		<tr class="RecAddTable">
			<th width="41"><input type="checkbox" class="" name="first"
				id="first" value="" />
			</th>
			<th width="83">收件人姓名</th>
			<th width="120">手机/电话</th>
			<th width="*">收件人地址</th>
			<th width="73">操作</th>
		</tr>
		<tr class="">
			<td width="41"><input type="checkbox" class=""
				name="delcheckbox" id="delcheckbox" value="" />
			</td>
			<td width="83">3GMall</td>
			<td width="120">15851888888</td>
			<td width="419">
				<form name="form1" method="post" action="">
					<span>洲：</span> <select name="zhou" id="zhou"
						onChange="Menu(this.form,1);">
						<option value="" selected>-----请选择-----</option>
						<option value='欧洲'>欧洲</option>
						<option value='亚洲'>亚洲</option>
						<option value='非洲'>非洲</option>
						<option value='大洋洲'>大洋洲</option>
						<option value='北美洲'>北美洲</option>
						<option value='南美洲'>南美洲</option>
					</select> <span>国家：</span> <select name="guo" id="select"
						onChange="Menu(this.form,2);">
						<option value="" selected>-----请选择-----</option>
					</select><br><span>城市：</span> <select name="shi" id="select2"
						onChange="Menu(this.form,3);">
						<option value="" selected>-----请选择-----</option>
					</select><br><span>地区：</span> <select name="qu" id="select3">
							<option value="" selected>-----请选择-----</option>
					</select> <script language="javascript">
						Menu(eval("document.form1"), 1)
					</script> <span>街道：</span> <input type="text" name="street" value=""
						id="street" style="width:160px;" class="" />
				</form></td>
			<td width="73"><input type="button" value="修改">
			</td>
		</tr>
	</table>
</body>
</html>