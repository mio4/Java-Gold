package com.mio4.dao;

import com.mio4.domain.PageBean;
import com.mio4.domain.Product;

import java.util.List;

public interface IProductDao {
	List<Product> findNew() throws Exception;

	List<Product> findHot() throws Exception;

	Product getByPid(String pid) throws Exception;


	List<Product> findByPage(int currPage, int pageSize, String cid) throws Exception;

	int getTotalCount(String cid) throws Exception;
}
