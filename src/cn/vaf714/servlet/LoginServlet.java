package cn.vaf714.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.vaf714.entity.User;
import cn.vaf714.service.UserService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	HttpServletRequest request;
	HttpServletResponse response;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.request = request;
		this.response = response;
		session = request.getSession();
		// 1.获取用户输入的数据
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");

		User user = new User(userName, password);
		User userFromDB = null;
		// 调用 service 层查询
		userFromDB = new UserService().login(Integer.parseInt(type), user);
		
		//转发
		if (type.equals("1")) {
			//普通用户登录
			generalUserLogin(user,userFromDB);
		}else{
			//管理员登录
			adminUserLogin(user,userFromDB);
		}
	}
	private void generalUserLogin(User user,User userFromDB) throws ServletException, IOException{
		if (userFromDB == null) {
			// 无此用户
			request.setAttribute("usernameError", "用户名错误");
			request.getRequestDispatcher("/general_user_login.jsp").forward(request, response);
		} else if (!user.getPassword().equals(userFromDB.getPassword())) {
			// 密码错误
			request.setAttribute("passwordError", "密码错误");
			request.getRequestDispatcher("/general_user_login.jsp").forward(request, response);
		} else {
			System.out.println(user.getUserName() + "登陆了");
			// 登录成功
			session.setAttribute("generalUser", userFromDB);
			response.getWriter().println("<script>alert('登录成功');window.open('queryCommodityServlet?type=1&id=','_self');</script>");
		}
	}
	private void adminUserLogin(User user,User userFromDB) throws ServletException, IOException{
		if (userFromDB == null) {
			// 无此用户
			request.setAttribute("usernameError", "用户名错误");
			request.getRequestDispatcher("/admin_user_login.jsp").forward(request, response);
		} else if (!user.getPassword().equals(userFromDB.getPassword())) {
			// 密码错误
			request.setAttribute("passwordError", "密码错误");
			request.getRequestDispatcher("/admin_user_login.jsp").forward(request, response);
		} else {
			System.out.println(user.getUserName() + "管理员登陆了");
			// 登录成功
			session.setAttribute("adminUser", userFromDB);
			response.getWriter().println("<script>alert('登录成功');window.open('queryCommodityServlet?type=2&id=','_self');</script>");
		}
	}
}
