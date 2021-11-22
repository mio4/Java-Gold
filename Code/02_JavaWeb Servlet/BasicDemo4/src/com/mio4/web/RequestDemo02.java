package com.mio4.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "RequestDemo02")
public class RequestDemo02 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		Enumeration<String> reqHeadInfos = request.getHeaderNames();
		out.write("所有的请求头如下：");
		out.write("<hr/>");
		while(reqHeadInfos.hasMoreElements()){
			String headName = (String) reqHeadInfos.nextElement();
			String headValue = request.getHeader(headName);
			out.write(headName + ":" + headValue);
			out.write("<br/>");
		}
		out.write("<br/>");
		out.write("获取到的客户端Accept-Encoding请求头的值：");
		String value = request.getHeader("Accept-Encoding");
		out.write(value);
		Enumeration<String> e = request.getHeaders("Accept-Encoding");
		while(e.hasMoreElements()){
			String s = (String) e.nextElement();
			System.out.println(s);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}
