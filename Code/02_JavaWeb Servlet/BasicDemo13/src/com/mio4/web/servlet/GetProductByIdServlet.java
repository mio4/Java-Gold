package com.mio4.web.servlet;

import com.mio4.web.domain.Product;
import com.mio4.web.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class GetProductByIdServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	/**
	 * 通过商品ID获取商品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//1.获取商品pid
		String pid = request.getParameter("pid");

		//2.调用Service
		Product p = null;
		try {
			p = new ProductService().getProductById(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//3.将Product放入Request域中
		request.setAttribute("bean",p);

		//4.请求转发到request域中
		request.getRequestDispatcher("/edit.jsp").forward(request,response);

	}
}
