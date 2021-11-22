package com.mio4.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceUtils {

	private static ComboPooledDataSource ds = new ComboPooledDataSource();

	/**
	 * @return datasource
	 */
	public static DataSource getDataSource(){
		return ds;
	}

	/**
	 * @return connection
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}



}
