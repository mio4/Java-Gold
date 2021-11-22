package com.mio4.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HeaderServlet")
public class HeaderServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("content-type","text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		//获取浏览器内核
		String userAgent = request.getHeader("user-agent");
		pw.write(userAgent);
		pw.write("</br>");
		//获取referer
		String referer = request.getHeader("referer");
		pw.write(referer);
		pw.write("</br>");
	}
}
