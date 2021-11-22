package com.mio4.web.servlet;

import com.mio4.domain.User;
import com.mio4.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户注册Servlet
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//1.封装数据
		User user =new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			//2.调用UserService
			int i = new UserService().regist(user);
			//3.判断返回的int值，将结果转发到msgServlet
			if(i == 1){
				request.setAttribute("msg","注册成功");
				request.getRequestDispatcher("/msg").forward(request,response);
			} else{
				request.setAttribute("/msg","注册失败");
				request.getRequestDispatcher("/msg").forward(request,response);
			}
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("Runtime Exception...");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}
