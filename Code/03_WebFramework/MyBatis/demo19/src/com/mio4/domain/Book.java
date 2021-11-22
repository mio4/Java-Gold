package com.mio4.domain;

import java.io.Serializable;

/**
 * CREATE TABLE TB_BOOK(
 * 	id INT(11) PRIMARY KEY AUTO_INCREMENT,
 * 	name VARCHAR(50),
 * 	author VARCHAR(20),
 * 	publicationdate DATE,
 * 	publication VARCHAR(100),
 * 	price DOUBLE,
 * 	image VARCHAR(20),
 * 	remark VARCHAR(20)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Book implements Serializable {
    private Integer id;
    private String name;
    private String author;
    private String publication_date;
    private String publication;
    private Double price;
    private String image;
    private String remark;

    public Book(){

    }

    public Book(Integer id, String name, String author, String publication_date, String publication, Double price, String image, String remark) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publication_date = publication_date;
        this.publication = publication;
        this.price = price;
        this.image = image;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publication_date='" + publication_date + '\'' +
                ", publication='" + publication + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublication_date() {
        return publication_date;
    }

    public String getPublication() {
        return publication;
    }

    public Double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getRemark() {
        return remark;
    }
}
