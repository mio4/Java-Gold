package com.mio4.web.domain;

import java.util.Date;

/**
 * 	JavaBean
 * 		create table `product` (
 * 			`pid` varchar (96),
 * 			`pname` varchar (150),
 * 			`market_price` double ,
 * 			`shop_price` double ,
 * 			`pimage` varchar (600),
 * 			`pdate` date ,
 * 			`pdesc` varchar (765)
 * 		);
 */
public class Product {
	private String pid;
	private String pname;
	private double market_price;

	private double shop_price;
	private String pimage;
	private Date pdate;
	private String pdesc;

	public void setPid(String pid) {
		this.pid = pid;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public void setMarket_price(double market_price) {
		this.market_price = market_price;
	}

	public void setShop_price(double shop_price) {
		this.shop_price = shop_price;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public String getPid() {
		return pid;
	}

	public String getPname() {
		return pname;
	}

	public double getMarket_price() {
		return market_price;
	}

	public double getShop_price() {
		return shop_price;
	}

	public String getPimage() {
		return pimage;
	}

	public Date getPdate() {
		return pdate;
	}

	public String getPdesc() {
		return pdesc;
	}
}
