package com.mio4.myConn;

import java.sql.Connection;
import java.sql.SQLException;

public class testDS {

	public static void main(String[] args) throws SQLException {
		MyDataSource mds = new MyDataSource();
		Connection conn = mds.getConnection();
		System.out.println(conn);
		conn.close();
	}
}
