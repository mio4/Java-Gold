package com.mio4.Dbtuils;

import com.mio4.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;

public class dbutilsDemo {

	@Test
	public void insert() throws SQLException {
		//创建QueryRunner对象
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into category values(?,?)";
		qr.update(sql,"c013","商品7");
	}
}
