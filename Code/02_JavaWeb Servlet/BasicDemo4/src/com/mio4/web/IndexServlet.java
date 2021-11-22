package com.mio4.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

//首页：列出所有的书
public class IndexServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//get session
		request.getSession();
		out.write("本网站有如下书：<br/>");
		Set<Map.Entry<String,Book>> set = DB.getAll().entrySet();
		for(Map.Entry<String,Book> me : set){
			Book book = me.getValue();
			String url = request.getContextPath() + "/servlet/BuyServlet?id=" + book.getId();
			//
			url = response.encodeURL(url); //这一行代码的意义何在？
			out.println(book.getName() + "	<a href='" + url + "'>购买</a><br/>");
		}
	}
}

class DB{
	private static Map<String,Book> map = new LinkedHashMap<String,Book>();
	static{
		map.put("1", new Book("1","javaWeb开发"));
		map.put("2", new Book("2","spring开发"));
		map.put("3", new Book("3","hibernate开发"));
		map.put("4", new Book("4","structs开发"));
		map.put("5", new Book("5","ajax开发"));
	}

	public static Map<String,Book> getAll(){
		return map;
	}
}

class Book{
	private String id;
	private String name;

	public Book(){
		super();
	}

	public Book(String id, String name){
		super();
		this.id = id;
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public void setId(){
		this.id = id;
	}

	public void setName(){
		this.name = name;
	}
}
