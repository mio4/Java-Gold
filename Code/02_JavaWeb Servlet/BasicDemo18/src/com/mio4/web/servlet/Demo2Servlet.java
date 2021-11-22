package com.mio4.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Demo2Servlet",urlPatterns={"/demo2","/demo2plus"},loadOnStartup = 2)
public class Demo2Servlet extends HttpServlet {

	@Override
	public void init() throws ServletException{
		System.out.println("Demo2Servlet init~");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Demo2Servlet收到请求");
	}
}
