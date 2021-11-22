package com.mio4.web.servlet;

import com.mio4.web.domain.Product;
import com.mio4.web.service.ProductService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "EditProductServlet")
public class EditProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		Product p = new Product();
		try {
			//1.封装数据
			BeanUtils.populate(p,request.getParameterMap());

			//2.调用Service
			new ProductService().editProduct(p);

			//3.重定向
			response.sendRedirect(request.getContextPath()+"/findAll" );
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg","修改商品失败");
			request.getRequestDispatcher("/msg.jsp").forward(request,response);
		}
	}
}
