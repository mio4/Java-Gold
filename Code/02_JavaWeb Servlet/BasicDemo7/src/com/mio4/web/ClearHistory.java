package com.mio4.web;

import com.mio4.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ClearHistory")
/**
 * 清空浏览记录
 */
public class ClearHistory extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.创建一个Cookie
		Cookie c = new Cookie("ids","");
		c.setPath(request.getContextPath()+"/");
		c.setMaxAge(0);
		//2.覆盖Cookie
		response.addCookie(c);
		response.sendRedirect(request.getContextPath()+"/product_list.jsp");
	}
}
