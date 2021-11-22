package com.mio4.service.impl;

import com.mio4.dao.IProductDao;
import com.mio4.dao.impl.ProductDaoImpl;
import com.mio4.domain.PageBean;
import com.mio4.domain.Product;
import com.mio4.service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
	public List<Product> findNew() throws Exception{
		IProductDao productDao = new ProductDaoImpl();
		return productDao.findNew();
	}

	public List<Product> findHot() throws Exception{
		IProductDao productDao = new ProductDaoImpl();
		return productDao.findHot();
	}

	/**
	 * 查询单个商品详情
	 * @param pid
	 * @return
	 */
	@Override
	public Product getByPid(String pid) throws Exception {
		IProductDao productDao = new ProductDaoImpl();
		return productDao.getByPid(pid);
	}

	/**
	 * 分页查询商品
	 * @param currPage
	 * @param pageSize
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageBean<Product> findByPage(int currPage, int pageSize, String cid) throws Exception {
		IProductDao productDao = new ProductDaoImpl();
		List<Product> list = productDao.findByPage(currPage,pageSize,cid);
		int totalCount = productDao.getTotalCount(cid);
		//return productDao.findByPage(currPage,pageSize,cid);
		return new PageBean<>(list,currPage,pageSize,totalCount);
	}
}
