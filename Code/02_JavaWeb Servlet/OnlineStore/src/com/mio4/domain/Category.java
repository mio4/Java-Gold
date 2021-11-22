package com.mio4.domain;

import java.io.Serializable;

/**
 * 商品分类
 * CREATE TABLE `category` (
 *   `cid` varchar(32) NOT NULL,
 *   `cname` varchar(20) DEFAULT NULL,
 *   PRIMARY KEY (`cid`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Category implements Serializable {
	private String cname;
	private String cid;

	public void setCname(String cname) {
		this.cname = cname;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public String getCid() {
		return cid;
	}
}
