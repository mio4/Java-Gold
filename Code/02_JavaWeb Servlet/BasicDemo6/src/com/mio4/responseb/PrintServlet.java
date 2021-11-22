package com.mio4.responseb;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PrintServlet")
public class PrintServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html;charset=UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		PrintWriter w = response.getWriter();
		w.print("<table border='1'>");
		w.print("<tr><td>中文user:</td>");
		w.print("<td>cat</td></tr>");
		w.print("<tr><td>password:</td>");
		w.print("<td>123456</td>");
		w.print("</tr></table>");

		ServletOutputStream os = response.getOutputStream();
		os.print("123");
	}
}
