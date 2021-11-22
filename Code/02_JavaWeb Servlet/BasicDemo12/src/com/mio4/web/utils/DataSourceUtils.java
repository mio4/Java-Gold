package com.mio4.web.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	private static ComboPooledDataSource ds=new ComboPooledDataSource();

	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();


	/**
	 * 获取数据源
	 * @return 连接池
	 */
	public static DataSource getDataSource(){
		return ds;
	}
	
	/**
	 * 获取连接
	 * @return 连接
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		//return ds.getConnection();

		//从当前线程上获取链接
		Connection conn = tl.get();
		if(conn == null){
			//第一次获取 创建一个链接和当前线程绑定
			conn = ds.getConnection();
			tl.set(conn);
		}
		return conn;
	}
	
	
	
	/**
	 * 释放资源
	 * 
	 * @param conn
	 *            连接
	 * @param st
	 *            语句执行者
	 * @param rs
	 *            结果集
	 */
	public static void closeResource(Connection conn, Statement st, ResultSet rs) {
		closeResource(st,rs);
		closeConn(conn);
	}

	public static void closeResource(Statement st, ResultSet rs) {
		closeResultSet(rs);
		closeStatement(st);
	}

	/**
	 * 释放连接
	 * 
	 * @param conn
	 *            连接
	 */
	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();

				//和当前的线程解除绑定
				tl.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}

	}

	/**
	 * 释放语句执行者
	 * 
	 * @param st
	 *            语句执行者
	 */
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			st = null;
		}

	}

	/**
	 * 释放结果集
	 * 
	 * @param rs
	 *            结果集
	 */
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}

	}

//*************************************************************
//事务相关函数
	/**
	 * 开启事务
	 * @throws SQLException
	 */
	public static void startTransaction() throws SQLException {
		//1.获取链接
		Connection connection = getConnection();

		//2.开启事务
		connection.setAutoCommit(false);
	}

	/**
	 * 提交事务以及释放资源
	 */
	public static void commitTransaction(){
		try {
			//1.获取链接
			Connection connection = getConnection();
			//2.提交事务
			connection.commit();
			//3.释放资源
			connection.close();
			//4.解除绑定
			tl.remove();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 事务回滚
	 */
	public static void rollbackTransaction(){
		try {
			//1.获取链接
			Connection connection = getConnection();
			//2.事务回滚
			connection.rollback();
			//3.释放资源
			connection.close();
			//4.解除绑定
			tl.remove();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
