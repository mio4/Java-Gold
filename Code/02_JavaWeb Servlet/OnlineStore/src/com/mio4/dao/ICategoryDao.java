package com.mio4.dao;

import com.mio4.domain.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryDao {
	List<Category> findAll() throws SQLException;
}
