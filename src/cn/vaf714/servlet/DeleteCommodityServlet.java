package cn.vaf714.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.vaf714.service.ManagerService;
/***
 * 删除商品
 * @author vaf714
 *
 */
public class DeleteCommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.获取删除的商品编号
		String id = request.getParameter("id");
		
		// 2.调用 service 层逻辑
		new ManagerService().deleteCommodity(id);
		
		System.out.println("管理员删除了一个商品id:" + id);
		
		// 3.转发到显示列表 servlet
		response.getWriter().println("<script>alert('删除成功');window.open('queryCommodityServlet?type=2&id=','_self');</script>");
	}

}
