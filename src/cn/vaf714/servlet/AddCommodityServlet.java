package cn.vaf714.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.vaf714.entity.Commodity;
import cn.vaf714.service.ManagerService;

/***
 * 添加商品
 * @author vaf714
 *
 */
public class AddCommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.获取管理员输入的信息并封装成 entity
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		int num = Integer.parseInt(request.getParameter("num"));

		Commodity commdity = new Commodity(id, name, price, num);

		// 2.调用 service 层处理业务逻辑
		boolean isSuccess = new ManagerService().addCommdity(commdity);

		// 3.根据处理结果，转发到相应位置
		if (isSuccess) {
			
			System.out.println("管理员添加了一个商品:" + name + ",id:" + id + ",price:" + price + ",num:" + num);
			
			// 添加成功
			response.getWriter().println("<script charset=\"utf-8\">alert('添加成功');window.open('queryCommodityServlet?type=2&id=','_self');</script>");
		} else {
			// 添加失败
			response.getWriter()
					.println("<script charset=\"utf-8\">alert('添加失败(请检查商品信息是否正确)');window.open(add_commodity.jsp ,'_self');</script>");
		}
	}

}
