package com.mio4.web.servlet;

import com.mio4.domain.Cart;
import com.mio4.domain.CartItem;
import com.mio4.domain.Product;
import com.mio4.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CartServlet")
public class CartServlet extends BaseServlet{
	private static final long serialVersionUID = -5385553872239659547L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * 获取购物车
	 * @param request
	 * @return
	 */
	public Cart getCart(HttpServletRequest request){
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart == null){
			cart = new Cart();
			request.getSession().setAttribute("cart",cart);
		}
		return cart;
	}

	/**
	 * 将商品添加到购物车
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("cart add");
		//1.获取Pid和商品数量
		String pid = request.getParameter("pid");
		int count = Integer.parseInt(request.getParameter("count"));
		//2.获取商品实体
		Product product = new ProductServiceImpl().getByPid(pid);
		//3.封装为CartItem
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setCount(count);
		//4.添加商品到购物车
		Cart cart = getCart(request);
		cart.add2Cart(cartItem);
		//5.重定向
		response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");
	}
}
