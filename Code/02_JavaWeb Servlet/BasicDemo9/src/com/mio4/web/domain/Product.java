package com.mio4.web.domain;

public class Product {
	private int id;
	private String pname;
	private double price;
	private String pdesc;

	public void setId(int id) {
		this.id = id;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public int getId() {
		return id;
	}

	public String getPname() {
		return pname;
	}

	public double getPrice() {
		return price;
	}

	public String getPdesc() {
		return pdesc;
	}
}
