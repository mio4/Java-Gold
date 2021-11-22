package com.mio4.web.servlet;

import com.mio4.domain.Customer;
import com.mio4.service.CustomerService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "CustomerServlet")
public class CustomerServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//1.接受请求参数
		Map<String,String[]> map = request.getParameterMap();
		//封装数据，使用BeanUtils，导入Jar包
		Customer c = new Customer();
		try {
			BeanUtils.populate(c,map);
			new CustomerService().addCustomer(c);
			System.out.println("添加用户成功");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
