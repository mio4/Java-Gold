package com.mio4.mapper;

import com.mio4.domain.Time;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TimeMapper {

    @Insert("INSERT INTO testtime(time) VALUES (#{time})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int saveTime(Time time);


    @Select("SELECT * FROM testtime")
    List<Time> selectAll();
}
