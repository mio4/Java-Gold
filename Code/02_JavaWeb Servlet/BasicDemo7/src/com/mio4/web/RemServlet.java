package com.mio4.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RemServlet")
/**
 * 记录用户上一次的访问时间
 */
public class RemServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		//1.获取指定名称的Cookie
		//Cookie[] c = request.getCookies();
		Cookie c = getCookieByName("lastQueryTime",request.getCookies());
		//2.判断Cookie是否为空
		if(c == null){
			pw.write("This is your first time to this site");
		} else{
			pw.write("The last time you visit the site is " + c.getValue());
		}
		//3.将当前时间保存到Cookie中
		c = new Cookie("lastQueryTime",System.currentTimeMillis()+"");
		c.setMaxAge(3600);
		c.setPath(request.getContextPath()+"/");
		pw.write("<hr>add path");
		response.addCookie(c);
	}

	public static Cookie getCookieByName(String key, Cookie[] cookies){
		Cookie c = null;
		for(Cookie co : cookies){
			if(co.getName().equals(key))
				return co;
		}
		return c;
	}
}
