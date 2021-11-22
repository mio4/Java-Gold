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

@WebServlet(name = "FindProductByConditionServlet")
public class FindProductByConditionServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//1.接受参数
		String pname = request.getParameter("pname");
		String keywords = request.getParameter("keywords");

		List<Product> plist = null;
		try {
			//2.调用Service，将list放入request域中
			plist = new ProductService().findProductByCondition(pname,keywords);
		} catch (SQLException e) {
			e.printStackTrace();
			//将异常存放到msg...
		}
		request.setAttribute("plist",plist);

		//3.请求转发
		request.getRequestDispatcher("/product_list.jsp").forward(request,response);
	}
}
