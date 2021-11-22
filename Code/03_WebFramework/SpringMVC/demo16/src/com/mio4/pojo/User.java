package com.mio4.pojo;

import org.springframework.web.multipart.MultipartFile;

public class User {
    private String username;
    private MultipartFile file;

    public User(){

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getUsername() {
        return username;
    }

    public MultipartFile getFile() {
        return file;
    }
}
