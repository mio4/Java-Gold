package com.mio4.test;

import com.mio4.domain.User;
import com.mio4.utils.sessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

public class InsertTest {
    public static void main(String[] args){
        //获取Session实例
        SqlSession sqlSession = sessionFactoryUtils.getSqlSession();
        //创造User对象
        User user = new User("mio","男",1000);
        sqlSession.insert("com.mio4.mapper.UserMapper.saveUser",user);
        sqlSession.commit();
        sqlSession.close();
    }
}
