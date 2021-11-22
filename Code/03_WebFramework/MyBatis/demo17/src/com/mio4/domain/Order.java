package com.mio4.domain;

import java.io.Serializable;
import java.util.List;

/**
 * CREATE TABLE TB_ORDER(
 * 	id INT PRIMARY KEY AUTO_INCREMENT,
 * 	code VARCHAR(20),
 * 	total DOUBLE,
 * 	user_id INT,
 * 	FOREIGN KEY (user_id) REFERENCES TB_USER(id)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */

//使用类来描述数据库中的外键约束
public class Order implements Serializable {
    private Integer id;
    private String code;
    private Double total;

    //用户和订单是一对多关系
    private User user;
    //商品和订单是多对多的关系
    private List<Article> articles;

    public Order(){

    }

    public Order(Integer id, String code, Double total, User user, List<Article> articles) {
        this.id = id;
        this.code = code;
        this.total = total;
        this.user = user;
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", total=" + total +
                ", user=" + user +
                ", articles=" + articles +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Double getTotal() {
        return total;
    }

    public User getUser() {
        return user;
    }

    public List<Article> getArticles() {
        return articles;
    }
}
