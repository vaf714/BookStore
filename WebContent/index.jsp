<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商城主页</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<script type="text/javascript" src="lib/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<script language="javascript" charset="utf-8">
	var user = "${sessionScope.generalUser}";
</script>
</head>
<body>
	<!-- 标题 -->
	<div class="tilte fixheight">Weclome To Book Store</div>

	<!-- 导航条 -->
	<div class="navdiv fixheight">
		<ul class="nav nav1 fixheight">
			<li><a href="general_user_login.jsp">登录</a></li>
			<li><a href="regist.jsp">注册</a></li>
			<li><a href="admin_user_login.jsp">管理商品</a></li>
		</ul>
		<ul class="nav nav2 fixheight">
			<li></li>
			<li><span class="username">用户名：${sessionScope.generalUser.userName }&nbsp;<a
					href="logoutServlet" class="quit">退出</a></span></li>
			<li><a href="showShoppingCartServlet">购物车</a></li>
			<li><a href="admin_user_login.jsp">管理商品</a></li>
		</ul>
	</div>

	<!-- 搜索框 -->
	<div class="search">
		<input type="text" placeholder="请输入商品编号" value="${requestScope.id }" />
		<button>查询</button>
	</div>

	<!-- 表格 -->
	<div class="content fixheight">
		<c:choose>
			<c:when test="${requestScope.commodities == '[]' }">没有找到商品！</c:when>
			<c:otherwise>
				<table>
					<thead>
						<tr>
							<th>编号</th>
							<th>名称</th>
							<th>价格</th>
							<th>库存</th>
							<th>购买</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${requestScope.commodities }" var="var">
							<tr>
								<td id="id">${var.id }</td>
								<td>${var.name }</td>
								<td>￥${var.price }</td>
								<td id="num">${var.num }</td>
								<td><a class="buy">购买</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>