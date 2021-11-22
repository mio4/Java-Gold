package com.mio4.domain;

public class Book {
    private Integer id;
    private String name;
    private String author;

    public Book(){
        super();
    }

    public Book(Integer id,String name, String author){
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}
