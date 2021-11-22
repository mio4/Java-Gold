package com.mio4.test;

import com.mio4.domain.User;
import com.mio4.factory.mySqlSessionFactory;
import com.mio4.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TwoLevelCacheTest {

    /**
     * 测试删除一个不存在的对象
     * 不会出现异常
     */
    @Test
    public void testDelete(){
        SqlSession sqlSession = mySqlSessionFactory.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.deleteUserById(10);

        sqlSession.close();
    }

    /**
     * 失败：原因不明
     */
    @Test
    public void testCache1(){
        SqlSession sqlSession = mySqlSessionFactory.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user1 = userMapper.selectUserById(1);
        System.out.println(user1);

        userMapper.deleteUserById(4);
        sqlSession.commit();

        //再次查询相同数据
        User user2 = userMapper.selectUserById(1);
        System.out.println(user2);
        sqlSession.close();
    }

    /**
     * 成功验证二级缓存
     */
    @Test
    public void testCache2(){
        SqlSession sqlSession = mySqlSessionFactory.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = userMapper.selectUserById(1);
        System.out.println(user1);
        sqlSession.close(); //关闭一级缓存

        sqlSession = mySqlSessionFactory.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        User user2 = userMapper.selectUserById(1);
        System.out.println(user2);

        sqlSession.close();
    }
}
