package com.mio4.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RequestDemo01")
public class RequestDemo01 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURL = request.getRequestURL().toString(); //得到请求的URL地址
		String requestURI = request.getRequestURI(); //得到请求的资源？
		String queryString = request.getQueryString(); //
		String remoteAddr = request.getRemoteAddr(); //得到请求的IP地址
		String remoteHost = request.getRemoteHost();
		String remoteUser = request.getRemoteUser();
		String method = request.getMethod();
		String pathInfo = request.getPathInfo();
		String localAddr = request.getLocalAddr(); //获取服务器IP地址
		String localName = request.getLocalName(); //获取服务器名称
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.write("获取的客户机如下：");
		out.write("<hr/>"); // hr/显示一条水平分割线
		out.write("请求的URL地址：" + requestURL);
		out.write("<hr/>");
		out.write("请求的资源：" + requestURI);
		out.write("<hr/>");
		out.write("请求的URL地址中附带的资源：" + queryString);
		out.write("<hr/>");
		out.write("请求的IP地址：" + remoteAddr);
		out.write("<hr/>");
		out.write("来访者的主机：" + remoteHost);
		out.write("<hr/>");
		out.write("来访者的主机：" + remoteUser);
		out.write("<hr/>");
		out.write("使用的方法：" + method);
		out.write("<hr/>");
		out.write("pathInfo:" + pathInfo);
		out.write("<hr/>");
		out.write("localAddr:" + localAddr);
		out.write("<hr/>");
		out.write("localName:" + localName);
	}
}
