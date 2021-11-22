package com.mio4.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ListCartServlet")
public class ListCartServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		List<Book> list = (List) session.getAttribute("list");
		if(list == null || list.size() == 0){
			out.write("对不起，你还没有购买任何商品！<br/>");
			return;
		}

		out.write("你买过如下商品：<br/>" );
		for(Book book : list){
			out.write(book.getName() + "<br/>");
		}

	}
}
