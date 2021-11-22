package com.mio4.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "CookieDemo01")
public class CookieDemo01 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		Cookie[] cookies = request.getCookies();
		//如果是用户第一次访问，那么得到的cookies将是null
		if(cookies == null){
			out.write("这是你第一次访问本站");
		} else{
			out.write("你上次访问的时间是");
			for(int i=0; i < cookies.length; i++){
				Cookie cookie = cookies[i];
				if(cookie.getName().equals("lastAccessTime")){
					Long lastAccessTime = Long.parseLong(cookie.getValue());
					Date date = new Date(lastAccessTime);
					out.write(date.toString());
				}
			}
		}

		//用户访问之后，更新最后的访问时间，然后发送到客户端
		Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis() + ""); //创建Cookie
		response.addCookie(cookie);
	}
}
