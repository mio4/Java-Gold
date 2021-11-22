package com.mio4.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "LifeFilter")
public class LifeFilter implements Filter {
	public void destroy() {
		System.out.println("filter die");
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig config) throws ServletException {
		System.out.println("filter init");
	}

}
