package com.mio4.web.filter;

import javax.servlet.*;
import java.io.IOException;

public class HelloFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig){
		//System.out.println("filter init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("过滤器HelloFilter 收到请求");
		chain.doFilter(request,response);
	}

	@Override
	public void destroy(){
		//System.out.println("filter die");
	}
}
