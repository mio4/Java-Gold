package com.mio4.web.dao;

import com.mio4.web.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import java.sql.SQLException;
import java.util.List;

public class KeywordDao {
	public List<Object> findKeywordByAja(String keyword) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select kw from keyword where kw like ? limit 5";
		return qr.query(sql,new ColumnListHandler("kw"),"%" + keyword + "%");
	}
}
