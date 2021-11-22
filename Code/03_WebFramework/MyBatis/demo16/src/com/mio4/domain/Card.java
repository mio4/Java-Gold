package com.mio4.domain;

import java.io.Serializable;

/**
 * CREATE TABLE tb_card(
 * 	id INT PRIMARY KEY AUTO_INCREMENT,
 * 	CODE VARCHAR(20)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Card implements Serializable {
    private Integer id; //主键
    private String code;

    public Card(){

    }

    public Card(Integer id,String code){
        this.id = id;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }
}
