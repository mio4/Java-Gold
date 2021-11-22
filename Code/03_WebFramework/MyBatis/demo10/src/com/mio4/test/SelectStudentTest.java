package com.mio4.test;

import com.mio4.domain.Student;
import com.mio4.utils.sessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SelectStudentTest {
    public static void main(String[] args){
        SqlSession sqlSession = sessionFactoryUtils.getSqlSession();
        List<Student> list = sqlSession.selectList("com.mio4.mapper.UserMapper.selectStudent");
        for(Student s : list){
            System.out.println(s);
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
