package com.mio4.service.impl;

import com.mio4.domain.Book;
import com.mio4.mapper.BookMapper;
import com.mio4.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    /**
     *
     * @return
     */
    @Override
    public List<Book> getAll() {
        return bookMapper.findAll();
    }
}
