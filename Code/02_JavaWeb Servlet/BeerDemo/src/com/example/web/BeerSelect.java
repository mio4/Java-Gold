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
		/* û�к�̨����İ汾
		response.setContentType("text/html"); //��������������Ӧ����������,��һ�о�����outPrintWriter��������ݻ���html�ı��ĸ�ʽ����������������ͻ�ȥ����.html�ļ���
		PrintWriter outPrintWriter = response.getWriter();
		outPrintWriter.println("Beer Selection Advice<br>");
		String c = request.getParameter("color"); //��POST�������ҵ�colorԪ�ض�Ӧ������
		outPrintWriter.println("<br>Got Beer color" + c);
		*/
		
		String c = request.getParameter("color");
		BeerExpert be = new BeerExpert();
		ArrayList result =  be.getBrands(c);
		/*
		response.setContentType("text/html"); //��û��out���֮ǰȷ������ı������ݺ�����
		PrintWriter out = response.getWriter();
		out.println("Beer Selection Advice<br/>");
		Iterator it = result.iterator(); //ctrl+shift+o���ٵ����
		while(it.hasNext()){
			out.print("<br/>try: " + it.next());
		}
		*/
		
		request.setAttribute("styles", result); //Ϊ����������һ�����ԣ���result.jspʹ��
		RequestDispatcher view = request.getRequestDispatcher("result.jsp"); //Ϊjspʵ����һ�����������
		view.forward(request, response); //��jsp�����������Ӧ
	}
}
