package com.mio4.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;

@WebServlet(name = "RequestDemo03")
public class RequestDemo03 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		String sex = request.getParameter("sex");
		String dept = request.getParameter("dept");
		//checkbox返回的是一个字符串数组
		String[] insts = request.getParameterValues("inst");
		String note = request.getParameter("note");
		String hiddenfield = request.getParameter("hiddenField");

		//获取兴趣字符串
		String instStr = "";
		for(int i=0; insts!=null && i < insts.length; i++){
			if(i == insts.length-1)
				instStr += insts[i];
			else
				instStr += insts[i] +",";
		}

		//格式化
		String htmlStr = "<table>" +
				"<tr><td>填写的编号:</td><td>{0}</td></tr>" +
				"<tr><td>填写的用户名:</td><td>{1}</td></tr>" +
				"<tr><td>填写的密码:</td><td>{2}</td></tr>" +
				"<tr><td>填写的性别:</td><td>{3}</td></tr>" +
				"<tr><td>填写的部门:</td><td>{4}</td></tr>" +
				"<tr><td>填写的兴趣:</td><td>{5}</td></tr>" +
				"<tr><td>填写的注释:</td><td>{6}</td></tr>" +
				"<tr><td>隐藏的部分:</td><td>{7}</td></tr>" +
				"</table>";
		htmlStr = MessageFormat.format(htmlStr,userid,username,userpass,sex,dept,instStr,note,hiddenfield);

		//输出
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(htmlStr);
	}
}
