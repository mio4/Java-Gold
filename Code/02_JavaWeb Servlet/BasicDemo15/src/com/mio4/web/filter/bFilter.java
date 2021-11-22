package com.mio4.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "bFilter")
public class bFilter implements Filter {
	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
		System.out.println("bFilter get the request");
		chain.doFilter(req, resp);
		System.out.println("bFilter get the response");
	}

	public void init(FilterConfig config) throws ServletException {

	}

}
