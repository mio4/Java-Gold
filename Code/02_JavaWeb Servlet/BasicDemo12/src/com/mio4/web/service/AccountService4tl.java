package com.mio4.web.service;

import com.mio4.web.dao.AccountDao4tl;
import com.mio4.web.utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountService4tl {
	public void account(String fromUser, String toUser, String money) throws SQLException, ClassNotFoundException {
		AccountDao4tl dao = new AccountDao4tl();
		Connection conn = null;
		try {
			//0.开启事务
			DataSourceUtils.startTransaction();

			//1.转出
			dao.accountOut(fromUser, money);

			//模拟断电操作
			int i = 1 / 0;

			//2.转入
			dao.accountIn(toUser, money);
			//3.提交事务
			DataSourceUtils.commitTransaction();
		} catch(Exception e){
			e.printStackTrace();
			//事务回滚
			DataSourceUtils.rollbackTransaction();
			throw(e);
		}

	}
}
