package com.mio4.dao;

import com.mio4.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class UserDaoTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception{
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource); //读取配置文件
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); //创建SessionFactory
        SqlSession sqlSession = sqlSessionFactory.openSession(); //创建session
    }

    @Test
    public void testFindUserById() throws Exception{
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void testFindUserByUsername() throws Exception{
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        List<User> users = userDao.findUserByUsername("张");
        System.out.println(users);
    }
}
