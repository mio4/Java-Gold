package com.mio4.web.servlet;

import com.mio4.domain.User;
import com.mio4.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SaveServlet")
public class SaveServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码...

		//1.获取参数...
		User user1 = new User();
		user1.setName("test 1");
		User user2 = new User();
		user2.setName("test 2");
		new UserService().save(user1,user2);
	}
}
