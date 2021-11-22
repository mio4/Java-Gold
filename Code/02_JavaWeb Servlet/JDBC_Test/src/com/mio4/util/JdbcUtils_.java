package com.mio4.util;

import java.sql.*;
import java.util.ResourceBundle;

public class JdbcUtils_ { //这是一个工具类
	static final String DRIVERCLASS;
	static final String URL;
	static final String USER;
	static final String PASSWORD;
	static{
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		 DRIVERCLASS = bundle.getString("driverClass");
		 URL = bundle.getString("url");
		 USER = bundle.getString("user");
		 PASSWORD = bundle.getString("password");
	}

	static{
		try {
			Class.forName(DRIVERCLASS);
		} catch(ClassNotFoundException e){

		}
	}

	//获取链接
	public static Connection getConnection() throws SQLException {
		//注册驱动
		//Class.forName("com.mysql.jdbc.Driver");

		//获取链接
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}

	/**
	 * 释放资源
	 * @param conn 连接
	 * @param st 语句执行者
	 * @param rs 结果集
	 */
	public static void closeResource(Connection conn, Statement st, ResultSet rs){
		closeResultSet(rs);
		closeStatement(st);
		closeConn(conn);
	}

	/**
		释放链接
		@param conn 链接
	 */
	public static void closeConn(Connection conn){
		if(conn != null){
			try{
				conn.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		conn = null; //保证垃圾回收机制的快速回收
	}

	/**
		释放Statement
	 */
	public static void closeStatement(Statement st){
		if(st != null){
			try{
				st.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		st = null;
	}

	/**
		释放结果集
	 */
	public static void closeResultSet(ResultSet rs){
		if(rs != null){
			try{
				rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		rs = null; //保证垃圾回收机制的快速回收
	}

}
