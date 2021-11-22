package com.mio4.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String loginname;
    private String password;

    public User(){
        super();
    }

    public User(String loginname, String password, String username){
        this.username = username;
        this.loginname = loginname;
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public String getLoginname() {
        return loginname;
    }

    public String getPassword() {
        return password;
    }
}
