package com.mio4.test;

import com.mio4.domain.Clazz;
import com.mio4.domain.Student;
import com.mio4.mapper.ClazzMapper;
import com.mio4.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class OneToManyTest {

    /**
     * 使用懒加载需要cglib.jar和asm.jar包
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        testSelectClazzById(sqlSession);
        //testSelectStudentById(sqlSession);
        sqlSession.commit();
        sqlSession.close();
    }

    public static void testSelectClazzById(SqlSession sqlSession){
        ClazzMapper clazzMapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = clazzMapper.SelectClazzById(1);
        System.out.println(clazz);

        List<Student> students = clazz.getStudent_list();
        for(Student student : students){
            System.out.println(student);
        }
    }

    public static void testSelectStudentById(SqlSession sqlSession){
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.SelectStudentById(1);
        System.out.println(student);
        student =  studentMapper.SelectStudentById(2);
        System.out.println(student);
    }

}
