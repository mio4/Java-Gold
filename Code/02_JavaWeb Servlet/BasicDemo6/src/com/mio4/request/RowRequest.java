package com.mio4.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RowRequest")
public class RowRequest extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("content-type","text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		//获取请求方式
		String method = request.getMethod();
		pw.write(method);
		pw.write("</br>");
		//获取请求资源
		String URI = request.getRequestURI();
		pw.write(URI);
		pw.write("</br>");
		String URL = request.getRequestURL().toString();
		pw.write(URL);
		pw.write("</br>");
		//获取请求字符串
		String query = request.getQueryString();
		pw.write(query);
		pw.write("</br>");
		//获取请求协议
		String protocol = request.getProtocol();
		pw.write(protocol);
		pw.write("</br>");
		//获取请求的IP
		String ip = request.getRemoteAddr();
		pw.write(ip);
		pw.write("</br>");
		//获取项目名称
		String path = request.getContextPath();
		pw.write(path);
		pw.write("</br>");

		pw.write("<hr>");
	}
}
