package com.mio4.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "msgServlet")
public class msgServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		response.setContentType("text/html;charset=UTF-8");
		//1.从Request域中获取内容
		String s = request.getAttribute("msg").toString();
		//2.将结果打印到页面上
		PrintWriter pw = response.getWriter();
		pw.write(s);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
