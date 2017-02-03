<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
	<center>
	<br><br><br>
		<form action="loginServlet" method="post">
			<table border="0" cellpadding="2" cellspacing="0">
				<tr height="40">
					<td align="right">用户名:</td>
					<td><input type="text" name="username" maxlength="10"/></td>
					<td width="80"><font color="red">${requestScope.usernameError}</font></td>
				</tr>
				
				<tr height="40">
					<td align="right">密&nbsp;码:</td>
					<td><input type="password" name="password" maxlength="10"/></td>
					<td><font color="red">${requestScope.passwordError}</font></td>
				</tr>
				
				<tr>
					<td><input type="hidden" name="type" value="1"/></td>
				</tr>
				
				<tr height="40">
					<td colspan="2" align="center"><input type="submit" value="登录" />&nbsp;
					<a href="regist.jsp"><input type="button" value="注册" /></a>&nbsp;
						<a href="queryCommodityServlet?type=1&id="><input
							type="button" value="返回首页" /></a></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>