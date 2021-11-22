package com.mio4.service;

import com.mio4.domain.Category;

import java.util.List;

public interface ICategoryService {

	List<Category> findAll() throws Exception;
}
