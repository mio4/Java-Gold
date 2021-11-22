package com.mio4.test;

import com.mio4.domain.Clazz;
import com.mio4.domain.Student;
import com.mio4.utils.sessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SelectClazzTest {
    public static void main(String[] args){
        SqlSession sqlSession = sessionFactoryUtils.getSqlSession();
        List<Clazz> clazz_list = sqlSession.selectList("com.mio4.mapper.UserMapper.selectClazz");
        for(Clazz clazz : clazz_list){
            System.out.println(clazz);
            List<Student> student_list = clazz.getStudents();
            for(Student student : student_list){
                System.out.println(student.getId() + " " + student.getName() + " " + student.getAge() + " " + student.getSex());
            }
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
