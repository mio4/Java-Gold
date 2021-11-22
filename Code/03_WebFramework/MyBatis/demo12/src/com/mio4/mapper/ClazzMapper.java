package com.mio4.mapper;

import com.mio4.domain.Clazz;

public interface ClazzMapper {
    //根据id查询学生信息
    Clazz SelectClazzById(Integer id);
}
