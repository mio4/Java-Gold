package com.mio4.C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mio4.util.JdbcUtils;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class C3p0Demo {

	@Test
	public void f1() throws SQLException, PropertyVetoException {
		//硬编码的方式
		ComboPooledDataSource ds = new ComboPooledDataSource();

		ds.setDriverClass("com.mysql.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql:///day07");
		ds.setUser("root");
		ds.setPassword("123456");

		Connection conn = ds.getConnection();
		String sql = "insert into category values(?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1,"c009");
		st.setString(2,"商品3");
		int i = st.executeUpdate();
		System.out.println(i);
		JdbcUtils.closeResource(conn,st,null);
	}

	@Test
	public void f2() throws SQLException {
		ComboPooledDataSource ds = new ComboPooledDataSource();

		Connection conn = ds.getConnection();
		String sql = "insert into category values(?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1,"c012");
		st.setString(2,"商品6");
		int i = st.executeUpdate();
		System.out.println(i);
		JdbcUtils.closeResource(conn,st,null);
	}
}
