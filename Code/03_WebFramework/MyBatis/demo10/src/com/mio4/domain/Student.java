package com.mio4.domain;

/**
 * CREATE TABLE TB_STUDENT(
 * 	id INT PRIMARY KEY AUTO_INCREMENT,
 * 	NAME VARCHAR(20),
 * 	age INT,
 * 	sex VARCHAR(20),
 * 	clazz_id INT,
 * 	FOREIGN KEY (clazz_id) REFERENCES TB_CLAZZ(id)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private Clazz clazz;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", clazz=" + clazz +
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

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
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

    public Clazz getClazz() {
        return clazz;
    }
}
