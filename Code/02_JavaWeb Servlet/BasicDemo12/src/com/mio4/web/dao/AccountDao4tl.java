package com.mio4.web.dao;

import com.mio4.web.utils.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao4tl {

	public void accountOut(String fromUser,String money) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection conn = null;
		try{
			//1.获取链接
			conn = DataSourceUtils.getConnection();
			//2.编写sql
			String sql = "update account set money = money - ? where name = ?";
			//3.语句执行者
			st = conn.prepareStatement(sql);
			st.setString(1,money);
			st.setString(2,fromUser);
			//4.执行sql
			int i = st.executeUpdate();
			System.out.println("转出成功");
		} catch(Exception e){
			e.printStackTrace();
			throw(e);
		} finally {
			DataSourceUtils.closeResource(st,rs);
		}
	}

	public void accountIn(String toUser,String money) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection conn = null;

		try{
			//1.获取链接
			conn = DataSourceUtils.getConnection();
			//2.编写sql
			String sql = "update account set money = money + ? where name = ?";
			//3.语句执行者
			st = conn.prepareStatement(sql);
			st.setString(1,money);
			st.setString(2,toUser);
			//4.执行sql
			int i = st.executeUpdate();
			System.out.println("转入成功");
		} catch(Exception e){
			e.printStackTrace();
			throw(e);
		} finally {
			DataSourceUtils.closeResource(st,rs);
		}
	}


}
