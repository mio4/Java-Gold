package com.mio4.web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CookieServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		response.setContentType("text/html;charset=UTF-8");
		//1.创建一个Cookie对象
		Cookie cookie = new Cookie("akey","avalue");
		//2.将Cookie写回浏览器
		response.addCookie(cookie);
		PrintWriter pw = response.getWriter();
		pw.write("Cookie写回成功");

		//------------------------------------------------------
		Cookie b = new Cookie("bkey","bvalue");
		response.addCookie(b);
		Cookie c = new Cookie("ckey","cvalue");
		response.addCookie(c);
		pw.write("<hr>Cookie写回成功2/2");
	}
}
