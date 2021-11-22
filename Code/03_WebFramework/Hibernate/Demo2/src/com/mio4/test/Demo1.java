package com.mio4.test;

import com.mio4.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.sql.*;

public class Demo1 {

	@Test
	public void testSave(){
		/**
		 * 	1. 先加载配置文件
		 * 	2. 创建SessionFactory对象，生成Session对象
		 *  3. 创建session对象
		 *  4. 开启事务
		 *  5. 编写保存的代码
		 *  6. 提交事务
		 *  7. 释放资源
		 */

		// 简写的方法
		Configuration config = new Configuration().configure();

		// 2. 创建SessionFactory对象
		SessionFactory factory = config.buildSessionFactory();
		// 3. 创建session对象
		Session session = factory.openSession();
		// 4. 开启事务
		Transaction tr = session.beginTransaction();

		// 5. 编写保存的代码
		Student s = new Student();
		s.setId(1);
		s.setName("mio");

		// 保存数据，操作对象就相当于操作数据库的表结构
		session.save(s);

		// 6. 提交事务
		tr.commit();
		// 7. 释放资源
		session.close();
		factory.close();
	}

	@Test
	public void testJDBC() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate_day01","root","123456");
		String sql = "select * from student";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("name"));
		}
		rs.close();
		st.close();
		connection.close();
	}
}
