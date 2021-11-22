package com.mio4.web.filter;

import com.mio4.web.domain.User;
import com.mio4.web.service.UserService;
import com.mio4.web.utils.CookieUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebFilter(filterName = "AutoLoginFilter")
public class AutoLoginFilter implements Filter {
	public void destroy() {
	}

	/**
	 *
	 * @param req
	 * @param resp
	 * @param chain
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
		//0.对Request强制类型转换
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		//1.获取Cookie
		Cookie cookie = CookieUtils.getCookieByName("autologin",request.getCookies());
		if(cookie != null){
			//获取username，调用Service进行登录
			String username = cookie.getValue().split("-")[0];
			String password = cookie.getValue().split("-")[1];

			User user = null;
			try {
				user = new UserService().login(username,password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(user != null){
				request.getSession().setAttribute("user",user);
			}
		}
		//2.放行
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig config) throws ServletException {

	}

}
