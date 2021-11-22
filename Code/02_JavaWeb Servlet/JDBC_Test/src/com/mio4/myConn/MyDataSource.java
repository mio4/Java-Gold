package com.mio4.myConn;

import com.mio4.util.JdbcUtils;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * 	使用连接池
 */

public class MyDataSource {

	static LinkedList<Connection> pool = new LinkedList<Connection>();

	static{ //初始化的时候需要放入三个连接
		for(int i=0; i < 3;i++){
			try {
				Connection conn = JdbcUtils.getConnection();
				pool.addLast(conn);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public static Connection getConnection(){ //从连接池中获取连接
		//获取连接的时候需要判断数据池是否为空
		if(pool.isEmpty()){
			try {
				Connection conn = JdbcUtils.getConnection();
				pool.addLast(conn);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		Connection conn = pool.removeFirst();
		ConnectionWrap connectionWrap = new ConnectionWrap(conn,pool);
		return connectionWrap;
		//return pool.removeFirst();
	}

	public static void addBack(Connection conn){ //归还连接
		pool.addLast(conn);
		System.out.println("归还连接");
	}

}
