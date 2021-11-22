package com.mio4.mapper;

import com.mio4.domain.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

public interface PersonMapper {

    @Select("SELECT * FROM TB_PERSON WHERE id = #{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "age",column = "age"),
            @Result(property = "card",column = "card_id", one = @One(
                select="com.mio4.mapper.CardMapper.selectCardById",
                    fetchType=FetchType.EAGER
                    ))
    })
    Person selectPersonById(Integer id);
}
