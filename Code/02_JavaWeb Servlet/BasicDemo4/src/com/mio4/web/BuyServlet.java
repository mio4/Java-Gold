package com.mio4.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BuyServlet")
public class BuyServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Book book = DB.getAll().get(id);

		//第一次的时候会创建一个ArrayList，以后会直接得到session里面的list容器
		HttpSession session = request.getSession();
		List<Book> list = (List) session.getAttribute("list"); //得到用户保存书的容器
		if(list == null){
			list = new ArrayList<Book>();
			session.setAttribute("list",list);
		}
		list.add(book);
		String url = response.encodeRedirectURL(request.getContextPath()+"/servlet/ListCartServlet"); //这行代码的意思是什么
		System.out.println(url);
		response.sendRedirect(url);
	}
}
