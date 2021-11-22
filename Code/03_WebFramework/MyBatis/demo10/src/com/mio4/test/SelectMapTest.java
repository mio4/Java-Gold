package com.mio4.test;

import com.mio4.utils.sessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class SelectMapTest {
    public static void main(String[] args){
        SqlSession sqlSession = sessionFactoryUtils.getSqlSession();
        List<Map<String,Object>> list = sqlSession.selectList("com.mio4.mapper.UserMapper.selectUser2");
        for(Map<String,Object> map : list){
            System.out.println(map);
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
