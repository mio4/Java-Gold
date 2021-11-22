package com.mio4.test;

import com.mio4.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession =  sqlSessionFactory.openSession();
        User user = new User("mio","男",25);
        sqlSession.insert("com.mio4.mapper.UserMapper.save",user);
        sqlSession.commit();
        sqlSession.close();
    }
}
