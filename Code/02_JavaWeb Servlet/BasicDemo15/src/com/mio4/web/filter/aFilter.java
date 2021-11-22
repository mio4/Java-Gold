package com.mio4.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "aFilter")
public class aFilter implements Filter {
	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
		System.out.println("aFilter get the request");
		chain.doFilter(req, resp);
		System.out.println("aFilter get the response");
	}

	public void init(FilterConfig config) throws ServletException {

	}

}
