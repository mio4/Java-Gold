package com.mio4.domain;

import java.io.Serializable;

/**
 * CREATE TABLE tb_person(
 * 	id INT PRIMARY KEY AUTO_INCREMENT,
 * 	name VARCHAR(20),
 * 	sex VARCHAR(20),
 * 	age INT,
 * 	card_id INT UNIQUE,
 * 	FOREIGN KEY(card_id) REFERENCES tb_card(id)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Person implements Serializable {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private Card card;

    public Person(){

    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", card=" + card +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Integer getAge() {
        return age;
    }

    public Card getCard() {
        return card;
    }
}
