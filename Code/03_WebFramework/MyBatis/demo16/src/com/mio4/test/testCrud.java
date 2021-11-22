package com.mio4.test;

import com.mio4.domain.User;
import com.mio4.factory.mySqlSessionFactory;
import com.mio4.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class testCrud {


    @Test
    public void testInsert(){
        SqlSession sqlSession = mySqlSessionFactory.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setName("testCrud");
        user.setSex("male");
        user.setAge(30);
        userMapper.saveUser(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectUser(){
        SqlSession sqlSession = mySqlSessionFactory.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.selectUserById(1);
        System.out.println(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = mySqlSessionFactory.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.selectUserById(6);
        user.setAge(18);
        userMapper.modifyUser(user);
        user = userMapper.selectUserById(6);
        System.out.println(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = mySqlSessionFactory.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.removeUser(9);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = mySqlSessionFactory.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> user_list = userMapper.selectAllUser();
//        for(User user : user_list){
//            System.out.println(user);
//        }
        user_list.forEach(user->System.out.println(user));

        sqlSession.commit();
        sqlSession.close();
    }








}
