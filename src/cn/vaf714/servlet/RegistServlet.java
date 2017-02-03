package cn.vaf714.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.vaf714.entity.User;
import cn.vaf714.service.UserService;

/***
 * 注册的Servlet
 * 
 * @author vaf714
 *
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.获取用户输入的用户名和密码
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		//System.out.println(userName);
		// 2.创建 entity
		User user = new User(userName, password);
		// 3.调用 service 把 entity 存入数据库
		boolean isSuccess = new UserService().addUser(user);
		if(isSuccess){
			
			System.out.println("注册一个用户:" + userName + ",密码:" + password);
			
			response.getWriter().println("<script>alert('注册成功');window.open('queryCommodityServlet?type=1&id=','_self');</script>");
			
		}else{
			response.getWriter().println("<script>alert('注册失败');window.open('regist.jsp','_self');</script>");
		}
		
		
	}

}
