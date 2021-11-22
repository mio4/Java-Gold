package com.mio4.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SessionDemo01")
public class SessionDemo01 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		session.setAttribute("mio4","我的名字");
		String sessionId = session.getId();
		if(session.isNew()){
			response.getWriter().write("session创建成功，session的id是：" + sessionId);
		} else{
			response.getWriter().write("服务器已经存在session了，对应的id是：" + sessionId);
		}
	}
}
