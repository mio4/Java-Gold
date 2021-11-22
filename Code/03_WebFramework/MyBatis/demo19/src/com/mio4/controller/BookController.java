package com.mio4.controller;

import com.mio4.domain.Book;
import com.mio4.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    @Qualifier(value = "bookService")
    private BookService bookService;

    @RequestMapping(value = "/main")
    public String main(Model model){
        List<Book> book_list = bookService.getAll();
        model.addAttribute("book_list",book_list);
        return "main";
    }

    @Test
    public void test1(){
        List<Book> book_list = bookService.getAll();
        for(Book book : book_list){
            System.out.println(book);
        }
    }
}
