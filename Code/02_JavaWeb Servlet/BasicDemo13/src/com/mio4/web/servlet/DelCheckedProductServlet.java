package com.mio4.web.servlet;

import com.mio4.web.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DelCheckedProductServlet")
public class DelCheckedProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	/**
	 * 删除多个选中的商品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		try {
			//1.获取商品ID
			String[] ids = request.getParameterValues("pid");

			//2.调用Service
			new ProductService().deleteManyProduct(ids);

			//3.（本页的工作已经完成）重定向到其他页面
			response.sendRedirect(request.getContextPath() + "/findAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
