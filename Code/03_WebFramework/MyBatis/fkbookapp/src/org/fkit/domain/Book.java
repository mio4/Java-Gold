package org.fkit.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * CREATE TABLE tb_book (
	id INT (11) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR (54),
	author VARCHAR (54),
	publicationdate DATE ,
	publication VARCHAR (150),
	price DOUBLE ,
	image VARCHAR (54),
	remark VARCHAR (600)
);
 * */
public class Book implements Serializable{
	
	private Integer id;				// id	
	private String name;			// 书名
	private String author;			// 作者
	private String publication;		// 出版社
	private Date publicationdate;	// 出版日期
	private Double price;			// 价格
	private String image;			// 封面图片
	private String remark;			// 详细描述
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public Date getPublicationdate() {
		return publicationdate;
	}
	public void setPublicationdate(Date publicationdate) {
		this.publicationdate = publicationdate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author
				+ ", publication=" + publication + ", publicationdate="
				+ publicationdate + ", price=" + price + ", image=" + image
				+ ", remark=" + remark + "]";
	}
	

}
