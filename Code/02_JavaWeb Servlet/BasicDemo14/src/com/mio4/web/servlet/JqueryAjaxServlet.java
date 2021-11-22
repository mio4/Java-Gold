package com.mio4.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * jQuery下的AJAX
 */
@WebServlet(name = "JqueryAjaxServlet")
public class JqueryAjaxServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("请求的方式:" + request.getMethod());

		//1.获取参数
		String username = request.getParameter("username");
		System.out.println(username);

		PrintWriter pw = response.getWriter();
		pw.write("success");
	}
}
