<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理商品</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<script type="text/javascript" src="lib/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		$(".search button").click(function() {
			var id = $(".search input").val();
			window.open("queryCommodityServlet?type=2&id=" + id, "_self");
		});
		$("tbody .alter").click(
				function() {
					var id = $(this).parent().prevAll("#id").text();
					var name = $(this).parent().prevAll("#name").text();
					var price = $(this).parent().prevAll("#price").text();
					var num = $(this).parent().prevAll("#num").text();
					window
							.open("alter_commodity.jsp?id=" + id + "&name="
									+ name + "&price=" + price + "&num=" + num,
									"_self");
					return false;
				});
		$("tbody .delete").click(function() {
			var id = $(this).parent().prevAll("#id").text();
			window.open("deleteCommodityServlet?id=" + id, "_self");
		});
	})
</script>
</head>
<body>
	<!-- 标题 -->
	<div class="tilte fixheight">Manage The Books</div>

	<!-- 导航条 -->
	<div class="navdiv fixheight">
		<ul class="nav fixheight">
			<li><span class="manager">管理员：${sessionScope.adminUser.userName }</span></li>
			<li><a href="add_commodity.jsp">添加商品</a></li>
			<li><a href="queryCommodityServlet?type=1&id=">返回首页</a></li>
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
							<th colspan="2">管&nbsp;&nbsp;理</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${requestScope.commodities }" var="var">
							<tr align="center" height="34">
								<td id="id">${var.id }</td>
								<td id="name">${var.name }</td>
								<td id="price">￥${var.price }</td>
								<td id="num">${var.num }</td>
								<td><a class="alter">修改</a></td>
								<td><a class="delete">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>