package com.mio4.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * CREATE TABLE user_inf (
 *   ID INT(11) NOT NULL AUTO_INCREMENT,
 *   loginname VARCHAR(20) NOT NULL,
 *   PASSWORD VARCHAR(16) NOT NULL,
 *   STATUS INT(11) NOT NULL DEFAULT '1',
 *   createdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 *   username VARCHAR(20) DEFAULT NULL,
 *   PRIMARY KEY (ID)
 * ) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 */
public class User implements Serializable {
    private Integer id;
    private String username;
    private String loginname;
    private String password;
    private Integer status;
    private Date createDate;

    public User(){

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getLoginname() {
        return loginname;
    }

    public String getPassword() {
        return password;
    }

    public Integer getStatus() {
        return status;
    }

    public Date getCreateDate() {
        return createDate;
    }
}
