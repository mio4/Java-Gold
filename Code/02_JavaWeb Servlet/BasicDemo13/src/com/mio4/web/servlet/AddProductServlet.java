package com.mio4.web.servlet;

import com.mio4.web.domain.Product;
import com.mio4.web.service.ProductService;
import com.mio4.web.utils.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

public class AddProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//添加令牌功能
		//0.1获取Session和提交的令牌
		String requestToken = request.getParameter("requestToken");
		//String sessionToken = request.getSession().getAttribute("sessionToken").toString();
		String sessionToken =  (String ) (request.getSession().getAttribute("sessionToken"));
		//0.2移除Session中的令牌
		request.getSession().removeAttribute("sessionToken");
		//0.3对比
		if(sessionToken == null || !sessionToken.equals(requestToken)){
			//已经提交过表单，避免重复提交
			request.setAttribute("msg","不能重复提交表单");
			request.getRequestDispatcher("/msg.jsp").forward(request,response);
			return;
		}
		//1.封装数据
		Product product = new Product();
		try {
			//Map map = request.getParameterMap();
			BeanUtils.populate(product,request.getParameterMap());

			//设置pid
			product.setPid(UUIDUtils.getId());
			//设置时间
			product.setPdate(new Date());
			//2.调用Service
			new ProductService().addProduct(product);
			//3.页面跳转
			request.getRequestDispatcher("/findAll").forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg","商品添加异常");
			request.getRequestDispatcher("/msg.jsp").forward(request,response);
		}
	}
}
