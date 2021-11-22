package com.mio4.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 在Filter中进行编码，防止中文乱码
 * 使用反射：加强方法
 */
@WebFilter(filterName = "EncodingFilter",urlPatterns = "/encoding")
public class EncodingFilter implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
		//1.强制类型转换
		final HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		//System.out.println("filter");

		//动态代理
		HttpServletRequest requestProxy =(HttpServletRequest) Proxy.newProxyInstance(HttpServletRequest.class.getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if("getParameter".equals(method.getName())){
					//获取请求对象
					String m = request.getMethod();
					if("get".equalsIgnoreCase(m)){
						String s = (String)method.invoke(request,args); //等价于request.getParameter(args);
						//return new String(s.getBytes("iso8859-1"),"utf-8");
						return s;
					} else if("post".equalsIgnoreCase(m)){
						request.setCharacterEncoding("UTF-8");
						return method.invoke(request,args);
					}
				}
				return method.invoke(request,args);
			}
		});

		//2.放行
		//将代理类传递到Servlet
		chain.doFilter(requestProxy, response);
	}

	public void init(FilterConfig config) throws ServletException {

	}

}
