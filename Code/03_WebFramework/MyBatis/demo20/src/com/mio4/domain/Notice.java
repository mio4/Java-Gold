package com.mio4.domain;

import java.util.Date;

/**
 * CREATE TABLE notice_inf (
 *   ID INT(11) NOT NULL AUTO_INCREMENT,
 *   TITLE VARCHAR(50) NOT NULL,
 *   CONTENT TEXT NOT NULL,
 *   CREATE_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 *   USER_ID INT(11) DEFAULT NULL,
 *   PRIMARY KEY (ID),
 *   KEY FK_NOTICE_USER (USER_ID),
 *   CONSTRAINT FK_NOTICE_USER FOREIGN KEY (USER_ID) REFERENCES user_inf (ID)
 * ) ENGINE=INNODB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
 */
public class Notice {
    private Integer di;
    private String title;
    private String content;
    private Date create_date; //发布日期
    private Integer user_id;

    //一个通知属于一个User
    private User user;

    public Notice(){

    }

    @Override
    public String toString() {
        return "Notice{" +
                "di=" + di +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", create_date=" + create_date +
                ", user_id=" + user_id +
                ", user=" + user +
                '}';
    }

    public Integer getDi() {
        return di;
    }

    public void setDi(Integer di) {
        this.di = di;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
