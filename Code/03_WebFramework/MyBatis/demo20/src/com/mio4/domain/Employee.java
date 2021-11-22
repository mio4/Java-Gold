package com.mio4.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 *CREATE TABLE employee_inf (
 *   ID INT(11) NOT NULL AUTO_INCREMENT,
 *   DEPT_ID INT(11) NOT NULL,
 *   JOB_ID INT(11) NOT NULL,
 *   NAME VARCHAR(20) NOT NULL,
 *   CARD_ID VARCHAR(18) NOT NULL,
 *   ADDRESS VARCHAR(50) NOT NULL,
 *   POST_CODE VARCHAR(50) DEFAULT NULL,
 *   TEL VARCHAR(16) DEFAULT NULL,
 *   PHONE VARCHAR(11) NOT NULL,
 *   QQ_NUM VARCHAR(10) DEFAULT NULL,
 *   EMAIL VARCHAR(50) NOT NULL,
 *   SEX INT(11) NOT NULL DEFAULT '1',
 *   PARTY VARCHAR(10) DEFAULT NULL,
 *   BIRTHDAY DATETIME DEFAULT NULL,
 *   RACE VARCHAR(100) DEFAULT NULL,
 *   EDUCATION VARCHAR(10) DEFAULT NULL,
 *   SPECIALITY VARCHAR(20) DEFAULT NULL,
 *   HOBBY VARCHAR(100) DEFAULT NULL,
 *   REMARK VARCHAR(500) DEFAULT NULL,
 *   CREATE_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 *   PRIMARY KEY (ID),
 *   KEY FK_EMP_DEPT (DEPT_ID),
 *   KEY FK_EMP_JOB (JOB_ID),
 *   CONSTRAINT FK_EMP_DEPT FOREIGN KEY (DEPT_ID) REFERENCES dept_inf (ID),
 *   CONSTRAINT FK_EMP_JOB FOREIGN KEY (JOB_ID) REFERENCES job_inf (ID)
 * ) ENGINE=INNODB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
 */
public class Employee implements Serializable {
    private Integer id;
    private String name;
    private String card_id;
    private String address;
    private String post_code;
    private String tel;
    private String qq_num;
    private String email;
    private Integer sex;
    private String party;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;
    private String race; //民族
    private String education; //教育
    private String speciality; //专业
    private String hobby;
    private String remark;
    private Date create_date; //建档日期

    //一个员工对应一个部门
    private Dept dept;
    //一个员工对应一个工作

    public Employee(){

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", card_id='" + card_id + '\'' +
                ", address='" + address + '\'' +
                ", post_code='" + post_code + '\'' +
                ", tel='" + tel + '\'' +
                ", qq_num='" + qq_num + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", party='" + party + '\'' +
                ", birthday=" + birthday +
                ", race='" + race + '\'' +
                ", education='" + education + '\'' +
                ", speciality='" + speciality + '\'' +
                ", hobby='" + hobby + '\'' +
                ", remark='" + remark + '\'' +
                ", create_date=" + create_date +
                ", dept=" + dept +
                '}';
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

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQq_num() {
        return qq_num;
    }

    public void setQq_num(String qq_num) {
        this.qq_num = qq_num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
