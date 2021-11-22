package com.mio4.test;

import com.mio4.domain.User;
import com.mio4.factory.mySqlSessionFactory;
import com.mio4.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class OneLevelCacheTest {
    public static void main(String[] args){
        //testCache1();
        testCache2();
        //testCache3();
        //testSearchResult();
    }

    /**
     * 测试一级缓存
     */
    public static void testCache1(){
        SqlSession sqlSession = mySqlSessionFactory.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectUserById(1);
        System.out.println(user);
        User user2 = userMapper.selectUserById(1);
        System.out.println(user2);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 插入delete操作
     */
    public static void testCache2(){
        SqlSession sqlSession = mySqlSessionFactory.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectUserById(1);
        System.out.println(user);

        userMapper.deleteUserById(5);
        //sqlSession.commit();

        User user2 = userMapper.selectUserById(1);
        System.out.println(user2);
        sqlSession.commit();
        sqlSession.close();
    }

    public static void testCache3(){
        SqlSession sqlSession = mySqlSessionFactory.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectUserById(1);
        System.out.println(user);
        sqlSession.close(); //close current session, and close the one-level cache

        //get session again
        sqlSession = mySqlSessionFactory.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        User user2 = userMapper.selectUserById(1);
        System.out.println(user2);
        sqlSession.commit();
        sqlSession.close();
    }

    public static void testSearchResult(){
        SqlSession sqlSession = mySqlSessionFactory.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //User user = userMapper.selectUserByAge(20);
        //User user = userMapper.selectUserByAge(23);
        //System.out.println(user);
        List<User> userList =  userMapper.selectUserByAge(23);
        for(User user : userList){
            System.out.println(user);
        }

        sqlSession.commit();
        sqlSession.close();
    }
}
