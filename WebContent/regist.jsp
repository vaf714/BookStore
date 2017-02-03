<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<script language="javascript" src="check.js" charset="utf-8"></script>
</head>
<body>
	<center>
		<br> <br> <br>
		<form action="registServlet" method="post"
			onsubmit="return registCheck(this);">
			<table border="0" cellpadding="2" cellspacing="0">
				<tr height="40">
					<td align="right">用户&nbsp;名:</td>
					<td><input type="text" id="username" name="username"
						maxlength="" /></td>
					<td id="nameinfo" width="130"></td>
				</tr>
				<tr height="40">
					<td align="right">密&nbsp;&nbsp;码:</td>
					<td><input type="password" id="password" name="password"
						maxlength="10" /></td>
					<td id="passwordinfo"></td>
				</tr>
				<tr height="40">
					<td align="right">确认密码:</td>
					<td><input type="password" id="password2" name="password2"
						maxlength="10" /></td>
					<td id="password2info"></td>
				</tr>
				<tr height="40">
					<td colspan="2" align="center"><input type="submit" value="注册" />&nbsp;
						<a href="general_user_login.jsp"><input type="button"
							value="登录" /></a>&nbsp; <a
						href="queryCommodityServlet?type=1&id="><input
							type="button" value="返回首页" /></a></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>