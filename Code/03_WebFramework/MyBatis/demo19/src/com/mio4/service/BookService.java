package com.mio4.service;

import com.mio4.domain.Book;

import java.util.List;

public interface BookService {

    /**
     * @return 查询的图书列表
     */
    List<Book> getAll();
}
