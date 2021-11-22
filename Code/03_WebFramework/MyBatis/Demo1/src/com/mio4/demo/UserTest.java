package com.mio4.demo;

import com.mio4.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserTest {

    @Test
    public void testFindUserById() throws SQLException, IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource); //读取配置文件
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); //创建SessionFactory
        SqlSession sqlSession = sqlSessionFactory.openSession(); //创建session
        //User user = sqlSession.selectOne("test.findUserById",1);
        //List<User> user = sqlSession.selectList("test.findUserByUsername","%小%");
        List<User> user = sqlSession.selectList("test.findUserByUsername","小");
        System.out.println(user);
    }

    @Test
    public void testUpdateUserById() throws Exception{
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource); //读取配置文件
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); //创建SessionFactory
        SqlSession sqlSession = sqlSessionFactory.openSession(); //创建session

        User user = new User();
        user.setId(22);
        user.setUsername("mio");
        sqlSession.update("test.updateUserById",user);
        sqlSession.commit();
    }

    @Test
    public void testInsertUser() throws Exception{
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource); //读取配置文件
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); //创建SessionFactory
        SqlSession sqlSession = sqlSessionFactory.openSession(); //创建session

        User user = new User();
        user.setUsername("mio");
        user.setBirthday(new Date());
        user.setSex("2");
        user.setAddress("shanghai");
        sqlSession.insert("test.insertUser",user);
        sqlSession.commit();

        System.out.println(user.getId());
    }
}
