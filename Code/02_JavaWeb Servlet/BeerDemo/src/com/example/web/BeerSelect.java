package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.BeerExpert;

public class BeerSelect extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		/* 没有后台处理的版本
		response.setContentType("text/html"); //首先设置请求相应的内容类型,这一行决定了outPrintWriter输出的数据会以html文本的格式被浏览器解析（发送回去的是.html文件）
		PrintWriter outPrintWriter = response.getWriter();
		outPrintWriter.println("Beer Selection Advice<br>");
		String c = request.getParameter("color"); //从POST数据中找到color元素对应的数据
		outPrintWriter.println("<br>Got Beer color" + c);
		*/
		
		String c = request.getParameter("color");
		BeerExpert be = new BeerExpert();
		ArrayList result =  be.getBrands(c);
		/*
		response.setContentType("text/html"); //在没有out输出之前确定输出文本的内容和类型
		PrintWriter out = response.getWriter();
		out.println("Beer Selection Advice<br/>");
		Iterator it = result.iterator(); //ctrl+shift+o快速导入包
		while(it.hasNext()){
			out.print("<br/>try: " + it.next());
		}
		*/
		
		request.setAttribute("styles", result); //为请求对象添加一个属性，供result.jsp使用
		RequestDispatcher view = request.getRequestDispatcher("result.jsp"); //为jsp实例化一个请求分配器
		view.forward(request, response); //向jsp发送请求和相应
	}
}
