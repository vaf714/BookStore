package cn.vaf714.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.vaf714.entity.GeneralUser;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GeneralUser generalUser2 = (GeneralUser)request.getSession().getAttribute("generalUser");
		System.out.println(generalUser2.getUserName() + "退出了");
		
		request.getSession().removeAttribute("generalUser");
		response.sendRedirect("queryCommodityServlet?type=1&id=");
	}
}
