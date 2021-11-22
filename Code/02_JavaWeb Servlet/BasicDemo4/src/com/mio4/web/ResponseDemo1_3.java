package com.mio4.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

@WebServlet(name = "ResponseDemo1_3")
public class ResponseDemo1_3 extends HttpServlet {
	private static final long serialVersionUID = 838438184692192124L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OutputOneByOutputStream(response);
	}

	public void OutputOneByOutputStream(HttpServletResponse response) throws IOException{
		response.setHeader("content-type","text/html;charset=UTF-8");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write("使用OutputStream流输出数字1:".getBytes("UTF-8"));
		//在开发过程中，如果需要服务器输出什么浏览器就显示什么，那么以字符串的形式输出是最稳的方式
		outputStream.write((1+"").getBytes());
		//outputStream.write("\n".getBytes());
		PrintWriter pw = response.getWriter(); //获取PrintWriter输出流
		pw.write(233+"");
	}
}
