package com.mio4.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品实体对象
 * CREATE TABLE `product` (
 * 		  `pid` varchar(32) NOT NULL,
 * 		  `pname` varchar(50) DEFAULT NULL,
 * 		  `market_price` double DEFAULT NULL,
 * 		  `shop_price` double DEFAULT NULL,
 * 		  `pimage` varchar(200) DEFAULT NULL,
 * 		  `pdate` date DEFAULT NULL,
 * 		  `is_hot` int(11) DEFAULT NULL,
 * 		  `pdesc` varchar(255) DEFAULT NULL,
 * 		  `pflag` int(11) DEFAULT NULL,
 * 		  `cid` varchar(32) DEFAULT NULL,
 * 		  PRIMARY KEY (`pid`),
 * 		  KEY `sfk_0001` (`cid`),
 * 		  CONSTRAINT `sfk_0001` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
 * 		) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Product implements Serializable {
	private String pid;
	private String pname;
	private double market_price;
	private double shop_price;
	private String pimage;
	private Date pdate;
	//商品是否热门 1-热门 0-不热门
	private Integer is_hot;
	private String pdesc;
	//商品是否下架
	private Integer pflag;
	//private String cid;
	//商品分类
	private Category category;

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

	public void setIs_hot(Integer is_hot) {
		this.is_hot = is_hot;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public void setPflag(Integer pflag) {
		this.pflag = pflag;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public Integer getIs_hot() {
		return is_hot;
	}

	public String getPdesc() {
		return pdesc;
	}

	public Integer getPflag() {
		return pflag;
	}

	public Category getCategory() {
		return category;
	}
}
