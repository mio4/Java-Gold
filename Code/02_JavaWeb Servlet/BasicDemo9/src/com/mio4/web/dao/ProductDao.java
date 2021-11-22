package com.mio4.web.dao;

import com.mio4.web.domain.Product;
import com.mio4.web.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDao {
	public List<Product> findAll() throws SQLException {
		//1.创建queryRunner对象
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		//2.编写SQL语句
		String sql = "select * from product";
		//3.执行SQL
		return qr.query(sql,new BeanListHandler<>(Product.class)); //返回的是一个关于Product的list
	}
}
