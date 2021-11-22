package com.mio4.web.servlet;

import com.mio4.web.domain.User;
import com.mio4.web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * 使用原生的AJAX检测用户名是否被占用
 */

@WebServlet(name = "CheckUsername4AjaxServlet")
public class CheckUsername4AjaxServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();

		//1.接受参数
		String username = request.getParameter("username");

		User user = null;
		try {
			//2.调用Service
			user = new UserService().checkUsername4Ajax(username);

			//3.判断User
			if(user == null){
				//pw.write("can use");
				pw.write("1");
			} else{
				//pw.write("can not use");
				pw.write("0");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
