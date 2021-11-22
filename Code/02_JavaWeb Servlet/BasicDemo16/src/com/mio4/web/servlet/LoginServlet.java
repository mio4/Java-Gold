package com.mio4.web.servlet;

import com.mio4.web.constant.Constant;
import com.mio4.web.domain.User;
import com.mio4.web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();

		//1.获取参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//2.调用Service
		User user = null;
		try{
			user = new UserService().login(username,password);
		} catch(Exception e){
			e.printStackTrace();
		}

		//3.判断User是否为空
		if(user == null){
			request.setAttribute("msg","用户名或密码不正确");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		} else{
			request.getSession().setAttribute("user",user);

			//判断是否勾选了自动登录
			if(Constant.IS_AUTO_LOGIN.equals(request.getParameter("autoLogin"))){ //创建Cookie
				Cookie cookie = new Cookie("autologin",username+"-"+password); //将用户名和密码写到Cookie中
				cookie.setMaxAge(3600);
				cookie.setPath(request.getContextPath() + "/success.jsp");

				response.addCookie(cookie);
			} else{

			}
			response.sendRedirect(request.getContextPath() + "/loginSuccess.jsp");
		}

	}
}
