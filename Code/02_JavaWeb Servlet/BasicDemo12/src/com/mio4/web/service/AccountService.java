package com.mio4.web.service;

import com.mio4.web.dao.AccountDao;
import com.mio4.web.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountService {
	public void account(String fromUser, String toUser, String money) throws SQLException, ClassNotFoundException {
		AccountDao dao = new AccountDao();
		Connection conn = null;
		try {
			//0.开启事务
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);
			//1.转出
			dao.accountOut(conn,fromUser, money);

			//模拟断电操作
			//int i = 1 / 0;

			//2.转入
			dao.accountIn(conn,toUser, money);
			//3.提交事务
			conn.commit();
		} catch(Exception e){
			e.printStackTrace();
			//事务回滚
			conn.rollback();
			JdbcUtils.closeConn(conn);
			throw(e);
		}

	}
}
