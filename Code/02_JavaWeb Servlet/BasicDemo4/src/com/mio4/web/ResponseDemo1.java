package com.mio4.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class ResponseDemo1 extends HttpServlet {
	private static final long serialVersionUID = -1245228127791645920L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		outputChineseByOutputStream(response);
	}

	public void outputChineseByOutputStream(HttpServletResponse response) throws IOException{
		String data = "中国";
		String data2 = "China";
		OutputStream outputStream = response.getOutputStream(); //获取response的OutputStream输出流
		//response.setCharacterEncoding("UTF-8");
		//response.setHeader("content-type","text/html;charset=utf-8"); //通过设置响应头来来控制浏览器以UTF-8的形式显示字符
		response.setContentType("text/html;charset=gbk");
		byte[] dataByteArr = data.getBytes();
		byte[] dataByteArr2 = data2.getBytes();
		outputStream.write(dataByteArr);
		outputStream.write(dataByteArr2);
		outputStream.write("中国".getBytes("UTF-8"));
	}

}
