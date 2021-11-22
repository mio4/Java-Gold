package com.mio4.domain;

import java.util.Date;

/**
 * CREATE TABLE document_inf (
 *   ID INT(11) NOT NULL AUTO_INCREMENT,
 *   TITLE VARCHAR(50) NOT NULL,
 *   filename VARCHAR(300) NOT NULL,
 *   REMARK VARCHAR(300) DEFAULT NULL,
 *   CREATE_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 *   USER_ID INT(11) DEFAULT NULL,
 *   PRIMARY KEY (ID),
 *   KEY FK_DOCUMENT_USER (USER_ID),
 *   CONSTRAINT FK_DOCUMENT_USER FOREIGN KEY (USER_ID) REFERENCES user_inf (ID)
 * ) ENGINE=INNODB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
 */
public class Document {
    private Integer id;
    private String title;
    private String filename;
    private Date create_date;
    private Integer user_id;

    //一个document属于一个user

    public Document(){

    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", filename='" + filename + '\'' +
                ", create_date=" + create_date +
                ", user_id=" + user_id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
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
}
