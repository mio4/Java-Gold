package com.mio4.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 购物车处理
 *
 */
@WebServlet(name = "Add2Cart")
public class Add2Cart extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		//1.获取商品名称
		String name = request.getParameter("name");
		//---首先以iso-8859-1的方式解析浏览器传送过来的中文数据
		//---然后以UTF-8的形式解码byte[]数组的字符，UTF-8的形式下能够解决中文乱码的问题
		//2.将商品添加到购物车
		Map<String,Integer> map = (Map<String,Integer>) request.getSession().getAttribute("cart");
		Integer count = 1;
		if(map == null){ //购物车为空，创建一个新的购物车
			map = new HashMap<String,Integer>();
			request.getSession().setAttribute("cart",map); //首次创建Session对象中的cart Attribute
		} else{
			count = map.get(name);
			if(count == null){
				count = 1;
			} else {
				count++;
			}
		}
		map.put(name,count);
		//3.提示信息
		pw.print("已经将<b>" + name + "</b>添加到购物车！<hr>");
		pw.print("<a href='" + request.getContextPath() + "/product_list.jsp'>继续购物</a><hr>");
		pw.print("<a href='" + request.getContextPath() + "/cart.jsp'>查看购物车</a>");
	}
}
