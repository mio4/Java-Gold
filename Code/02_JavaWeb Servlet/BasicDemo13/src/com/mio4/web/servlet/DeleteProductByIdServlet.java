package com.mio4.web.servlet;

import com.mio4.web.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteProductByIdServlet")
public class DeleteProductByIdServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("UTF-8");

		try {
			//1.获取商品ID
			String pid = request.getParameter("pid");

			//2.调用Service完成操作
			new ProductService().deleteProductById(pid);

			//3.重定向到findAllServlet
			response.sendRedirect(request.getContextPath() + "/findAll");
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg","商品删除失败");
			request.getRequestDispatcher("/msg").forward(request,response);
		}

	}
}
