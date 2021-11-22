package com.mio4.controller;

import com.mio4.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @RequestMapping(value = "/main")
    public String main(Model model){
        System.out.println("main方法执行~");
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("JavaEE","author1",10.0));
        bookList.add(new Book("JavaSE","author2",20.0));
        model.addAttribute("bookList",bookList);
        return "main"; //跳转到main视图
    }
}
