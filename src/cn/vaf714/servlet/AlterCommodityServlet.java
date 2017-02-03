package cn.vaf714.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.vaf714.entity.Commodity;
import cn.vaf714.service.ManagerService;

public class AlterCommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.获取要修改的id
		String beforAlterId = request.getParameter("beforAlterId");	
		// 2.获取修改后的信息
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		int num = Integer.parseInt(request.getParameter("num"));
		Commodity commodity = new Commodity(id, name, price, num);
		
		// 3.调用 service 层处理修改逻辑
		boolean isSuccess = new ManagerService().alterCommodity(beforAlterId,commodity);
		
		// 4.反馈
		if(isSuccess){
			
			System.out.println("管理员修改了了一个商品修改后的信息:" + name + ",id:" + id + ",price:" + price + ",num:" + num);
			
			response.getWriter().println("<script>alert('修改成功');window.open('queryCommodityServlet?type=2&id=','_self');</script>");
		}else{
			String url = "alter_commodity.jsp?id=" + beforAlterId + "&name=" + name + "&price=" + price + "&num=" + num;
			response.getWriter().println("<script>alert('修改失败');window.open('" + url + "','_self');</script>");
		}
	}
}
