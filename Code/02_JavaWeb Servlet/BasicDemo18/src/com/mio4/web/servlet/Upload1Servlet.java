package com.mio4.web.servlet;


import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 使用Servlet3.0/4.0 文件上传
 * 1. 使用request.getPart（）获取文件
 * 2. part.getHeader("Content-Disposition")获取文件头信息
 * 3. @MultipartConfig实现文件上传
 */
@WebServlet(name = "Upload1Servlet",urlPatterns="/upload1")
@MultipartConfig
public class Upload1Servlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码

		//1.获取内容
		String username = request.getParameter("username");
		System.out.println(username);

		Part part = request.getPart("file");
		System.out.println(part);


		String fileName = part.getName();

		//获取上传的文件名
		String dis = part.getHeader("Content-Disposition");
		System.out.println(dis.substring(dis.indexOf("filename=")+10,dis.length()-1));

		InputStream is = part.getInputStream();
		FileOutputStream fos = new FileOutputStream("F://" + fileName);
		IOUtils.copy(is,fos);
		fos.close();
		is.close();
	}
}
