package com.mio4.web.service;

import com.mio4.web.dao.AccountDao4DB;
import com.mio4.web.utils.DataSourceUtils;

import java.sql.SQLException;

public class AccountService4DB {
	public void account(String fromUser, String toUser, String money) throws SQLException {
		AccountDao4DB dao = new AccountDao4DB();
		try{
			//0.开启事务
			DataSourceUtils.startTransaction();
			//1.转出
			dao.accountOut(fromUser,money);

			//2.模拟中断
			int i = 1 / 0;

			//3.转入
			dao.accountInt(toUser,money);

			//4.提交
			DataSourceUtils.commitTransaction();
		} catch(Exception e){
			e.printStackTrace();
			DataSourceUtils.rollbackTransaction();
			throw(e);
		}
	}
}
