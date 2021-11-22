package com.mio4.web.dao;

import com.mio4.web.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AccountDao {
	/**
	 * @param fromUser
	 * @param money
	 */
	public void accountOut(Connection conn,String fromUser,String money){
		PreparedStatement st = null;
		ResultSet rs = null;

		try{
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
		} finally {
			JdbcUtils.closeStatement(st);
			JdbcUtils.closeResultSet(rs);
		}
	}

	public void accountOut_(String fromUser,String money){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try{
			//1.获取连接
			conn = JdbcUtils.getConnection();
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
		} finally {
			JdbcUtils.closeResource(conn,st,rs);
		}
	}

	public void accountIn(Connection conn,String toUser,String money){
		PreparedStatement st = null;
		ResultSet rs = null;

		try{
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
		} finally {
			JdbcUtils.closeStatement(st);
			JdbcUtils.closeResultSet(rs);
		}
	}

	public void accountIn_(String toUser,String money){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try{
			//1.获取连接
			conn = JdbcUtils.getConnection();
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
		} finally {
			JdbcUtils.closeResource(conn,st,rs);
		}
	}
}
