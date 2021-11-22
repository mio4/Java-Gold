package com.mio4.demo4;

public class Car2 {

	private String cname;
	private double price;

	public void setCname(String cname) {
		this.cname = cname;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car2{" +
				"cname='" + cname + '\'' +
				", price=" + price +
				'}';
	}
}
