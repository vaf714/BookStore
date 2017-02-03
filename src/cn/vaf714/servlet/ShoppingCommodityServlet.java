package cn.vaf714.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.vaf714.entity.GeneralUser;
import cn.vaf714.service.UserService;

public class ShoppingCommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.获取购买的商品id和数量以及用户
		String buyCommodityId = request.getParameter("id");
		int buyNum = Integer.parseInt(request.getParameter("num"));
		GeneralUser user = (GeneralUser) request.getSession().getAttribute("generalUser");
		// 2.加入购物车
		new UserService().addToCart(user,buyNum,buyCommodityId);
		
		System.out.println(user.getUserName() + "购买了" + buyNum + "本id为 " + buyCommodityId + "的书");
		
		// 3.反馈
		response.getWriter().println("<script>alert('添加成功');window.open('queryCommodityServlet?type=1&id=','_self');</script>");
	}
}
