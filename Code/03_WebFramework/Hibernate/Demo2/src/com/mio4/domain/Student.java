package com.mio4.domain;

/**
 * create table student(
 * 	id int auto_increment,
 * 	name varchar(20),
 * 	PRIMARY KEY (id)
 * )ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;
 */
public class Student {
	private String name;
	private Integer id;

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}
}
