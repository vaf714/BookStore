package cn.vaf714.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.vaf714.entity.Commodity;
import cn.vaf714.service.ManagerService;

public class QueryCommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		// 1.获取用户输入的商品编号
		String id = request.getParameter("id");

		if (id == null) {
			id = "";
		}
		// 2.调用 service 层执行业务逻辑
		List<Commodity> commodities = new ManagerService().queryCommodity(id);

		System.out.println(type + "查询了id:" + id);

		request.setAttribute("id", id);//用于回显
		request.setAttribute("commodities", commodities);
		// 3.反馈
		if (type == null || type.equals("1")) {
			// 普通用户查看商品
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			// 管理员查看商品
			request.getRequestDispatcher("/manager.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
