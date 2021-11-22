package com.mio4.web;

import com.mio4.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "ProductServlet")
public class ProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//0.设置编码
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();

		//1.获取指定的Cookie
		String id = request.getParameter("id");
		Cookie c = CookieUtils.getCookieByName("ids",request.getCookies());
		String ids = "";
		//2.判断Cookie是否是为空
		if(c == null){
			ids = id;
		} else{
			ids = c.getValue();
			String[] arr = ids.split("-");
			List<String> asList = Arrays.asList(arr);
			LinkedList<String> list = new LinkedList<>(asList);
			if(list.contains(id)){ //将id移除，放在最前面
				list.remove(id);
				list.addFirst(id);
			} else{ //判断历史记录列表长度
				if(list.size() >= 3){
					list.removeLast();
					list.addFirst(id);
				} else{ //直接将id放在最前面
					list.addFirst(id);
				}
			}
			ids = "";
			for(String s : list){
				ids += (s + "-");
			}
		}
		//将ids写回Cookie
		c = new Cookie("ids",ids.substring(0,ids.length()-1));
		//设置返回路径
		c.setPath(request.getContextPath() + "/");
		c.setMaxAge(3600);
		response.addCookie(c);
		//3.跳转到指定的商品页面上
		response.sendRedirect(request.getContextPath()+ "/product/" + id + ".html");
	}
}
