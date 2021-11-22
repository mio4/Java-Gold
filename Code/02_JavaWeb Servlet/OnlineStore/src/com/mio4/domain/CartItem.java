package com.mio4.domain;

import java.io.Serializable;

/**
 * 购物车项
 */
public class CartItem implements Serializable {
	private Product product; //商品
	private Integer count; //商品购买数量
	private Double subTotal; //小计

	public CartItem(){

	}

	public CartItem(Product product, Integer count) {
		this.product = product;
		this.count = count;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

/*	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}*/

	public Product getProduct() {
		return product;
	}

	public Integer getCount() {
		return count;
	}

	public Double getSubTotal() {
		return product.getShop_price() * count;
		//return subTotal;
	}

}
