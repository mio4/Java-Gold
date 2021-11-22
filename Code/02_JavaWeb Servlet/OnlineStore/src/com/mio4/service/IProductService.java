package com.mio4.service;

import com.mio4.domain.PageBean;
import com.mio4.domain.Product;

import java.util.List;

public interface IProductService {
	List<Product> findNew() throws Exception;

	List<Product> findHot() throws Exception;

	Product getByPid(String pid) throws Exception;

	PageBean<Product> findByPage(int currPage, int pageSize, String cid) throws Exception;
}
