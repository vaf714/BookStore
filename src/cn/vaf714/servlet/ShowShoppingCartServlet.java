package cn.vaf714.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.vaf714.entity.CartList;
import cn.vaf714.entity.GeneralUser;
import cn.vaf714.service.UserService;

public class ShowShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GeneralUser user = (GeneralUser) request.getSession().getAttribute("generalUser");
		// 1.得到 List
		List<CartList> shoppingCart = new UserService().getCart(user);
		
		request.setAttribute("shoppingCart", shoppingCart);
		request.setAttribute("shoppingCartPrice", new UserService().countShoppingCartPrice(shoppingCart));
		request.setAttribute("shoppingCartNum", new UserService().countShoppingCartNum(shoppingCart));
		// 2.反馈
		request.getRequestDispatcher("/show_shopping_cart.jsp").forward(request, response);
	}

}
