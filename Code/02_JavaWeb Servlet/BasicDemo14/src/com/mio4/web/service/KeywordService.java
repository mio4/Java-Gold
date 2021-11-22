package com.mio4.web.service;

import com.mio4.web.dao.KeywordDao;

import java.sql.SQLException;
import java.util.List;

public class KeywordService {

	public List<Object> findKeywordByAja(String keyword) throws SQLException {
		return new KeywordDao().findKeywordByAja(keyword);
	}
}
