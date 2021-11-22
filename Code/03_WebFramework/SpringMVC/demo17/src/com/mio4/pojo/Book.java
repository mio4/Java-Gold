package com.mio4.pojo;

public class Book {
    private String name;
    private String author;
    private double price;

    public Book(){

    }

    public Book(String name,String author,double price){
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
}
