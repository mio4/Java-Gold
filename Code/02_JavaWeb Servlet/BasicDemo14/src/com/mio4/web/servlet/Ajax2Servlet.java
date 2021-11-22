package com.mio4.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Ajax2Servlet")
public class Ajax2Servlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		System.out.println(request.getMethod());
		//1.接受参数
		String username = request.getParameter("username");
		System.out.println("post" + username);

		//2.相应数据
		response.getWriter().write("姓名：" + username);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//1.接受参数
		String username = request.getParameter("username");
		System.out.println(username);

		//2.相应数据
		response.getWriter().write("姓名：" + username);
	}
}
