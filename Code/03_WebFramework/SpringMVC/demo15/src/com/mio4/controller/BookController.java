package com.mio4.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mio4.domain.Book;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/json")
public class BookController {
    private static final Log logger = LogFactory.getLog(BookController.class);

    //接受JSON+发送JSON
    @RequestMapping(value = "/testRequestBody")
    public void setJson(@RequestBody Book book, HttpServletResponse response)  throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        logger.info(mapper.writeValueAsString(book));
        book.setAuthor("写书人");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(mapper.writeValueAsString(book));
    }

    //发送JSON
    @RequestMapping(value = "/testResponseBody")
    @ResponseBody
    public Object getJon(){
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book(1,"SpringMVC企业应用实战","author1"));
        bookList.add(new Book(2,"SpringMVC企业开发实战","author2"));
        return bookList;
    }

}
