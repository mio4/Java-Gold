package com.mio4.test;

import com.mio4.domain.User2;
import com.mio4.utils.sessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ResultMapTest {
    public static void main(String[] args){
        SqlSession sqlSession = sessionFactoryUtils.getSqlSession();
        List<User2> list = sqlSession.selectList("com.mio4.mapper.UserMapper.selectUser3");
        for(User2 user: list){
            System.out.println(user);
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
