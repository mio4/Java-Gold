package com.mio4.demo4;

/**
 * 构造方法的注入方式
 */
public class Car1 {
	private String cname;
	private String price;

	public Car1(String cname, String price) {
		this.cname = cname;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car1{" +
				"cname='" + cname + '\'' +
				", price='" + price + '\'' +
				'}';
	}
}
