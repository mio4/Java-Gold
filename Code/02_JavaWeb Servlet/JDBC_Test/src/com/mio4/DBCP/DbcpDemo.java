package com.mio4.DBCP;

import com.mio4.util.JdbcUtils;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DbcpDemo {

	@Test
	public void f1() throws SQLException {
		//使用硬编码的方式
		BasicDataSource ds = new BasicDataSource();

		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql:///day07");
		ds.setUsername("root");
		ds.setPassword("123456");

		Connection conn = ds.getConnection();
		String sql = "insert into category values(?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1,"c007");
		st.setString(2,"商品");
		int i = st.executeUpdate();
		System.out.println(i);
		JdbcUtils.closeResource(conn,st,null);
	}

	@Test
	public void f2() throws Exception {
		//
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/dbcp.properties"));
		DataSource ds = new BasicDataSourceFactory().createDataSource(prop);

		Connection conn = ds.getConnection();
		String sql = "insert into category values(?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1,"c008");
		st.setString(2,"商品2");
		int i = st.executeUpdate();
		System.out.println(i);
		JdbcUtils.closeResource(conn,st,null);
	}
}
