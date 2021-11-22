package com.mio4.Crud;

import com.mio4.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class CrudDemo {

	@Test
	public void arrayHandler() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "select * from category;";

		//Object[] queries = qr.query(sql,new ArrayHandler());
		List<Object[]> queries = qr.query(sql, new ArrayListHandler());
		for(Object[] o : queries){
			System.out.println(Arrays.toString(o));
		}
	}

	@Test
	public void beanHandler() throws SQLException{
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category";
		Category bean = qr.query(sql, new BeanHandler<>(Category.class));
		System.out.println(bean.getCid() + ":" + bean.getCname());
	}

	@Test
	public void beanListHandler() throws SQLException{
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from category";
		List<Category> list = qr.query(sql, new BeanListHandler<>(Category.class));
		for (Category bean : list) {
			System.out.println(bean.getCid() + ":" + bean.getCname());
		}
	}
}
