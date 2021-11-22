package com.mio4.web.dao;

import com.mio4.web.domain.User;
import com.mio4.web.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;


public class UserDao {

	/**
	 * 检测用户名是否被占用
	 * @param username
	 * @return
	 */
	public User getUserByUsername4Ajax(String username) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username = ? limit 1";
		return qr.query(sql, new BeanHandler<>(User.class),username);
	}
}
