package com.mio4.Hello;

import com.mio4.util.JdbcUtils;
import com.mio4.util.JdbcUtils_;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Hello {
	@Test
	public void f1(){
		//System.out.println("Hello");
	}

	@Test
	public void f2() throws ClassNotFoundException,java.sql.SQLException {
		//注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//DriverManager.registerDriver(new Driver());

		//获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day07","root","123456");

		//创建语句执行
		String sql = "select * from category";

		//设置参数
		PreparedStatement st = conn.prepareStatement(sql);

		//执行SQL
		ResultSet rs = st.executeQuery();

		//处理结果
		while(rs.next()){
			System.out.println(rs.getString("cid") + ":" + rs.getString("cname"));
		}

		//释放资源
		rs.close();
		st.close();
		conn.close();

	}

	@Test
	public void f3(){ //往category表插入一条数据
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement st = null;

		try {
			conn = JdbcUtils_.getConnection();
			String sql = "insert into category values(?,?)";
			st = conn.prepareStatement(sql);
			st.setString(1,"c006");
			st.setString(2,"其他");
			int i = st.executeUpdate();
			if(i == 1){
				System.out.println("success");
			} else{
				System.out.println("fail");
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			//释放资源
			JdbcUtils.closeResource(conn,st,rs);
		}
	}

	//对于数据库的更新操作
	@Test
	public void f4(){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils_.getConnection();
			String sql = "update category set cname=? where cid=?";
			st = conn.prepareStatement(sql);
			st.setString(1,"户外工具");
			st.setString(2,"c005");
			int i = st.executeUpdate();
			if(i == 1){
				System.out.println("success");
			} else{
				System.out.println("failed");
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			JdbcUtils_.closeResource(conn,st,rs);
		}
	}


	//删除一条信息
	@Test
	public void f5(){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils_.getConnection();
			String sql = "delete from category where cid=?";
			st = conn.prepareStatement(sql);
			st.setString(1,"c005");
			int i = st.executeUpdate();
			if(i == 1){
				System.out.println("success");
			} else{
				System.out.println("failed");
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			JdbcUtils_.closeResource(conn,st,rs);
		}
	}
}
