package com.mio4.web.servlet;

import com.mio4.web.domain.PageBean;
import com.mio4.web.domain.Product;
import com.mio4.web.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 每次从MySQL中查找一页的数据
 * MySQL中分页通过limit关键词
 * select * from product limit 0,3 //从第1条之后的3条
 * select * from product limit 3,3 //从第4条之后的3条
 * select * from product limit 6,3 //从第7条之后的3条
 */
@WebServlet(name = "ShowProductByPageServlet")
public class ShowProductByPageServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("UTF-8");

		//1.获取参数：currPage
		int currPage = Integer.parseInt(request.getParameter("currPage"));
		//固定每页显示的条数
		int pageSize = 3;
		PageBean<Product> pageBean = null;

		try {
			pageBean = new ProductService().showProductByPage(currPage,pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//2.调用Service，返回PageBean，将pageBean放入在域中
		request.setAttribute("pageBean",pageBean);

		//3.请求转发
		request.getRequestDispatcher("/product_page.jsp").forward(request,response);

	}
}
