package com.mio4.responsed;



import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class DownloadServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		response.setHeader("content-type","txt/html"); //故意输错类型，查看浏览器反应
		response.getWriter().write("Hello");
		*/

		String fileName = request.getParameter("name");
		ServletContext servletContext = this.getServletContext();
		String mimeType = servletContext.getMimeType(fileName);
		response.setHeader("content-disposition","attachment;filename=" + fileName);
		InputStream is = servletContext.getResourceAsStream("/download/" + fileName);
		ServletOutputStream os = response.getOutputStream();
		int len = -1;
		byte[] b = new byte[1024];
		while((len=is.read(b)) != -1){
			os.write(b,0,len);
		}
		//IOUtils.copy(is,os); 无效的jar包 下载方式
		os.close();
		is.close();
	}
}
