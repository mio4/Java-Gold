package com.mio4.util;

import java.sql.*;

public class JdbcUtils { //这是一个工具类
	//获取链接
	public static Connection getConnection() throws ClassNotFoundException,SQLException {
		//注册驱动
		Class.forName("com.mysql.jdbc.Driver");

		//获取链接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day07","root","123456");

		return conn;
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
