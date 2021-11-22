package org.fkit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.fkit.domain.Book;

/**
 * BookMapper接口
 * */
public interface BookMapper {

	/**
	 * 查询所有图书
	 * @return 图书对象集合
	 * */
	@Select(" select * from tb_book ")
	List<Book> findAll();
	
}
