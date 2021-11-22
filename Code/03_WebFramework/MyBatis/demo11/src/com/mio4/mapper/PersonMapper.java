package com.mio4.mapper;

import com.mio4.domain.Person;

public interface PersonMapper {
    /**
     * 根据id查询Person
     */
    Person SelectPersonById(Integer id);
}
