package com.mio4.dao.impl;

import com.mio4.dao.ICategoryDao;
import com.mio4.domain.Category;
import com.mio4.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {
	public List<Category> findAll() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category";
		return qr.query(sql, new BeanListHandler<>(Category.class));
	}
}
