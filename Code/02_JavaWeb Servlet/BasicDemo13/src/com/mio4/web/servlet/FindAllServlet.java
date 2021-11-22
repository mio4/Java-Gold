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
import java.util.List;

/**
 * 1.将数据库中所有的商品展示到前台
 */
@WebServlet(name = "FindAllServlet")
public class FindAllServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		response.setContentType("text/html;charset=UTF-8");

		//1.调用Service方法，返回list
		List<Product> plist = null;
		try {
			plist = new ProductService().findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//2.将list放入request域中
		request.setAttribute("plist",plist);

		//3.转发
		request.getRequestDispatcher("/product_list.jsp").forward(request,response);
	}
}
