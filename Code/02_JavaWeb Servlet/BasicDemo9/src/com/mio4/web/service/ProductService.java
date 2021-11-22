package com.mio4.web.service;

import com.mio4.web.dao.ProductDao;
import com.mio4.web.domain.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {

	public List<Product> findAll() throws SQLException {
		return new ProductDao().findAll();
	}
}
