package com.mio4.web.dao;

import com.mio4.web.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class AccountDao4DB {
	public void accountOut(String fromUser, String money) throws SQLException {
		//1.创建QueryRunner
		QueryRunner qr = new QueryRunner();

		//2.SQL语句
		String sql = "update account set money = money - ? where name = ?";

		//3.执行SQL
		qr.update(DataSourceUtils.getConnection(),sql,money,fromUser);
	}

	public void accountInt(String toUser, String money) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "update account set money = money + ? where name = ?";
		qr.update(DataSourceUtils.getConnection(),sql,money,toUser);
	}
}
