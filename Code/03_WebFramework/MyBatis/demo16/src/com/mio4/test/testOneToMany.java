package com.mio4.test;

import com.mio4.domain.Clazz;
import com.mio4.domain.Student;
import com.mio4.factory.mySqlSessionFactory;
import com.mio4.mapper.ClazzMapper;
import com.mio4.mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class testOneToMany {

    /**
     * 测试根据班级id查询学生信息
     * 【学生信息 + 班级Code】
     */
    @Test
    public void testSelectStudentByClazzId(){
        SqlSession sqlSession = mySqlSessionFactory.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student_list = studentMapper.selectStudentByClazzId(1);
        student_list.forEach(student->System.out.println(student));
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 根据班级id查找班级信息
     * 顺便把班级下所有学生信息查找出来
     */
    @Test
    public void testSelectClazzByClazzId(){
        SqlSession sqlSession = mySqlSessionFactory.getSqlSession();
        ClazzMapper clazzMapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = clazzMapper.selectClazzByClazzId(1);
        System.out.println(clazz);
        List<Student> student_list = clazz.getStudents();
        student_list.forEach(student -> System.out.println(student));
        sqlSession.commit();
        sqlSession.close();
    }
}
