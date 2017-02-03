<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
<script language="javascript" src="check.js" charset="utf-8"></script>
</head>
<body>
	<center>
	<br><br><br>
		<form action="addCommodityServlet" method="post" onsubmit="return CommodityInfoCheck(this);">
			<table border="0" cellpadding="1" cellspacing="0">
				<tr height="40">
					<td width="50">编号:</td>
					<td><input type="text" name="id" maxlength="11"/></td>
					<td id="idInfo" width="170"></td>
				</tr>
				<tr height="40">
					<td>名称:</td>
					<td><input type="text" name="name" maxlength="100"/></td>
					<td id="nameInfo"></td>
				</tr>
				<tr height="40">
					<td>价格:</td>
					<td><input type="text" name="price" maxlength="10"/></td>
					<td id="priceInfo"></td>
				</tr>
				<tr height="40">
					<td>数量:</td>
					<td><input type="text" name="num" maxlength="10"/></td>
					<td id="numInfo"></td>
				</tr>
				<tr height="40">
					<td colspan="2" align="center"><input type="submit" value="添加" />&nbsp;
						<input type="reset" value="重置" />&nbsp; <a
						href="queryCommodityServlet?type=2&id="><input
							type="button" value="返回管理页" /></a></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>