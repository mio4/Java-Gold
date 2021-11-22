package com.mio4.web.servlet;

import com.mio4.domain.Customer;
import com.mio4.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 初始化添加联系人的页面
 */
@WebServlet(name = "initServlet")
public class initServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Customer> list = new CustomerService().findAll();
		request.setAttribute("list",list);
		request.getRequestDispatcher("/jsp/linkman/add.jsp").forward(request,response);
	}
}
