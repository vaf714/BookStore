<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购买的物品</title>
</head>
<body>
	<center>
	<br><br>
		<table border="1" cellspacing="0" cellpadding="0">
			<tr height="50">
				<th width="90">名称</th>
				<th width="90">价格</th>
				<th width="90">购买数量</th>
			</tr>
			<c:forEach items="${requestScope.shoppingCart }" var="var">
				<tr align="center" height="34">
					<td>${var.commodityName }</td>
					<td>￥${var.commodityPrice }</td>
					<td>${var.buyNum }</td>
				</tr>
			</c:forEach>
			<tr align="center" height="40">
				<th>总计</th>
				<th>￥${requestScope.shoppingCartPrice }</th>
				<th>${requestScope.shoppingCartNum }</th>
			</tr>
		</table>
		<br><br>
		<center>
			<a href="queryCommodityServlet?type=1&id="><input type="button" value="返回主页"></a>
		</center>
	</center>
</body>
</html>