package com.mio4.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ResponseDemo2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	private void downloadFileByOutputStream(HttpServletResponse response) throws FileNotFoundException,IOException{
		String realPath = this.getServletContext().getRealPath("/download/1.JPG");
		String fileName = realPath.substring(realPath.indexOf("\\")+1);

	}
}
