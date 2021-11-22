package com.mio4.web.dao;

import com.mio4.web.domain.User;
import com.mio4.web.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
	public User login(String username, String password) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username = ? and password = ?";
		return qr.query(sql,new BeanHandler<>(User.class),username,password);
	}
}
