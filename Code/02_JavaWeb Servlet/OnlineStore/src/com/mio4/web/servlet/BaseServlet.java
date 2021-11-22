package com.mio4.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 通用的Servlet
 * 重写service()方法即可：使用反射
 */
@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response){
		try {

			//System.out.println("base");

			//1.获取子类
			//妙！	**注意这里this的作用**
			Class clazz = this.getClass();

			//2.获取请求方法
			String m = request.getParameter("method");

			if(m == null){
				m = "index";
			}

			//3.获取方法对象
			Method method = clazz.getMethod(m,HttpServletRequest.class,HttpServletResponse.class);

			//4.执行方法,返回值是请求转发的路径
			String s = (String) method.invoke(this,request,response);

			//5.判断s是否为空
			if(s != null){
				request.getRequestDispatcher(s).forward(request,response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("base servlet");
	}

	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}
}
