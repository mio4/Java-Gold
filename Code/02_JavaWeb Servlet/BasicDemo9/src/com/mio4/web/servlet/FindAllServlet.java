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
 *  0. 导入c3p0 dbutils jstl mysql-connector standard包
 *  1. index连接指向findall servlet
 *  2. 使用queryRunner从数据库中查询到商品结果，用BeanListHandler处理转换为list
 *  3. 将list存储到request的域中，这样不需要将list作为参数直接传到jsp页面
 *  4. request.getRequestDispatcher转发到product_list页面
 *  5. product_list页面中使用JSTL Core核心库从request域中得到plist，遍历plist，将结果以表格的形式展示
 */

@WebServlet(name = "FindAllServlet")
public class FindAllServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		response.setContentType("text/html;charset=UTF-8");
		//1.调用service
		List<Product> plist = null;
		try {
			plist = new ProductService().findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//2.将list放在request的域中
		request.setAttribute("plist",plist);

		//3.请求转发
		request.getRequestDispatcher("/product_list.jsp").forward(request,response);
	}
}
