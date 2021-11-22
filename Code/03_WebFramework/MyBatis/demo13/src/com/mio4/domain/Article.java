package com.mio4.domain;

import java.io.Serializable;
import java.util.List;

/**
 * CREATE TABLE TB_ARTICLE(
 * 	id INT PRIMARY KEY AUTO_INCREMENT,
 * 	name VARCHAR(20),
 * 	price DOUBLE,
 * 	remark VARCHAR(20)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Article implements Serializable {
    private Integer id;
    private String name;
    private Double price;
    private String remark;

    //商品中没有外键约束
    //但商品和订单是多对多的关系
    private List<Order> orders;

    public Article(){

    }

    public Article(Integer id, String name, Double price, String remark, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.remark = remark;
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", remark='" + remark + '\'' +
                ", orders=" + orders +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getRemark() {
        return remark;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
