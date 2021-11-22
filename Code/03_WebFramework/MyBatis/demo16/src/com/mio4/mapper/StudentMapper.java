package com.mio4.mapper;

import com.mio4.domain.Student;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface StudentMapper {
    @Select("SELECT * FROM TB_STUDENT WHERE clazz_id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "age",column = "age"),
            @Result(property = "clazz",column = "clazz_id", one = @One(
                    select = "com.mio4.mapper.ClazzMapper.selectClazzByStudentClazzId",fetchType = FetchType.EAGER
            ))

    })
    List<Student> selectStudentByClazzId(Integer id);
}
