package com.mio4.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

@WebServlet(name = "ParamServlet")
public class ParamServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request,response);
		//*********************************************************
		request.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		pw.write("获取表单的请求参数:");
		//获取用户名
		String username_ = request.getParameter("username");
		String password_ = request.getParameter("password");
		//username_ = new String(username_.getBytes("iso8859-1"),"utf-8");
		System.out.println(username_);
		System.out.println(password_);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("content-type","text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		//获取username
		String username = request.getParameter("username");
		pw.write("username：" + username);
		pw.write("<hr>");

		//获取爱好
		String[] hobby = request.getParameterValues("hobby");
		pw.write("hobby：" + Arrays.toString(hobby));
		pw.write("<hr>");

		//获取所有参数
		Map<String,String[]> map = request.getParameterMap();
		for(String key : map.keySet()){
			pw.write(key + ":" + Arrays.toString(map.get(key)));
		}
		pw.write("<hr>");

	}
}
