package com.mio4.mapper;

import com.mio4.domain.Clazz;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

public interface ClazzMapper {

    //在查找班级信息时，将班级下所有学生的所有信息查找出来
    @Select("SELECT * FROM TB_CLAZZ WHERE id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "code",column = "CODE"),
            @Result(property = "students",column = "id",many = @Many(
                    select = "com.mio4.mapper.StudentMapper.selectStudentByClazzId",fetchType = FetchType.EAGER
            ))
    })
    Clazz selectClazzByClazzId(Integer id);


    //在只查询学生信息的时候，顺便把班级的code查找出来，使用@One标签
    @Select("SELECT * FROM TB_CLAZZ WHERE id = #{id}")
    Clazz selectClazzByStudentClazzId();
}
