package com.mio4.web.servlet;

import com.mio4.domain.User;
import com.mio4.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 用户登录Servlet
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//接受用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//调用UserService的login方法
		User user = null;
		try {
			//本行代码出现异常
			user = new UserService().login(username,password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("网络异常...");
		}

		//判断user是否为空
		if(user == null){
			response.setHeader("refresh","3;url=/BasicDemo5/loginReg/login.html");
			response.getWriter().write("用户名和密码不匹配<br/>");
			response.getWriter().write("即将为你跳转到登录页面...");
		} else{
			ServletContext servletContext = this.getServletConfig().getServletContext();
			response.getWriter().write(user.getUsername() + "Welcome back!");
		}


	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}
