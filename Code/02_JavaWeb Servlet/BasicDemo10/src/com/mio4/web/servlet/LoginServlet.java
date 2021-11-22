package com.mio4.web.servlet;

import com.mio4.domain.User;
import com.mio4.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 用户登录Servlet
 *
 * 本次练习在登陆时加入验证码功能以及记住用户名
 * 1. 使用img从CodeServlet中接受生成的验证码
 * 2. 在CodeServlet中将msg字符串加入到session的域对象中，保证能够在其他Servlet中使用
 * 3. login.jsp中的form表单添加checkbox元素，选择是否记住用户名
 * 4. 如果勾选了记住用户名并且登陆成功，则将username写回cookie
 * 5. 在login.jsp中使用JSTL标签添加cookie.saveName.value即保存的用户名
 *
 *
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//接受两个验证码:用户输入的验证码和生成的验证码
		String rCode = request.getParameter("checkcode");
		String sCode = (String) request.getSession().getAttribute("checkcode");
		//使用之后将验证码从session中移除
		request.getSession().removeAttribute("checkcode");
		if(rCode.trim().length() == 0 || !rCode.equals(sCode)){
			request.setAttribute("msg","验证码错误，请重新输入");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
			return;
		}

		//接受用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//调用UserService的login方法
		User user = null;
		try {
			user = new UserService().login(username,password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("网络异常...");
		}

		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(request.getParameter("savename"));
		//判断user是否为空
		if(user == null){
			request.setAttribute("msg","用户名和密码不匹配");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
			return;
		} else{ //如果勾选了记住用户名，则将user放入session中
			if("ok".equals(request.getParameter("savename"))){
				//创建Cookie username不能使用中文
				Cookie cookie = new Cookie("saveName",username);
				cookie.setPath(request.getContextPath() + "/");
				cookie.setMaxAge(3600);
				response.addCookie(cookie);
			}
			request.getSession().setAttribute("user",user);
		}

		response.sendRedirect(request.getContextPath()+"/index.jsp"); //将页面重定向到首页？
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}
