package com.mio4.mapper;

import com.mio4.domain.Card;
import org.apache.ibatis.annotations.Select;

public interface CardMapper {
    @Select("SELECT * FROM TB_CARD WHERE id = #{id}")
    Card selectCardById(Integer id);

}
