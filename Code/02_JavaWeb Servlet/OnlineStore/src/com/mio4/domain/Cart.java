package com.mio4.domain;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车对象
 */
public class Cart implements Serializable {
	private Map<String,CartItem> cartItemMap = new LinkedHashMap<>();//存放购物车项 key:商品id，value：CartItem对象
	private Double totalPrice = 0.0; //总金额

	//商品添加到购物车
	public void add2Cart(CartItem cartItem){
		//先判断是否有同类商品
		String pid = cartItem.getProduct().getPid();
		if(cartItemMap.containsKey(pid)){
			CartItem cartItem1 = cartItemMap.get(pid);
			cartItem1.setCount(cartItem1.getCount()+1);
		} else{
			cartItemMap.put(pid,cartItem);
		}

		//2.修改总金额
		totalPrice += cartItem.getSubTotal();
	}

	//从购物车删除商品
	public void removeFromCart(String pid){
		//1.从集合中删除
		CartItem cartItem = cartItemMap.remove(pid);
		//2.修改总价
		totalPrice -= cartItem.getSubTotal();
	}
	//清空购物车
	public void clearCart(){
		cartItemMap.clear();
		totalPrice = 0.0;
	}

	public void setCartItemMap(Map<String, CartItem> cartItemMap) {
		this.cartItemMap = cartItemMap;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Map<String, CartItem> getCartItemMap() {
		return cartItemMap;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

}
