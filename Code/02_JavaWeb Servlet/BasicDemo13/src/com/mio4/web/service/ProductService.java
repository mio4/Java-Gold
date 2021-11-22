package com.mio4.web.service;

import com.mio4.web.dao.ProductDao;
import com.mio4.web.domain.PageBean;
import com.mio4.web.domain.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {

	/**
	 * 查询所有的商品
	 * @return list<Product>
	 */
	public List<Product> findAll() throws SQLException {
		return new ProductDao().findAll();
	}

	/**
	 * 向数据库中添加商品
	 * @param product
	 * @throws SQLException
	 */
	public void addProduct(Product product) throws SQLException {
		new ProductDao().addProduct(product);
	}

	/**
	 * 通过ID查找商品
	 * @param pid 商品id
	 * @return Product对象
	 */
	public Product getProductById(String pid) throws SQLException {
		return new ProductDao().getProductById(pid);
	}

	public void editProduct(Product p) throws SQLException {
		new ProductDao().editProduct(p);
	}

	/**
	 * 通过pid删除对应商品
	 * @param pid
	 */
	public void deleteProductById(String pid) throws SQLException {
		new ProductDao().deleteProduct(pid);
	}

	/**
	 * 删除指定ID（多个）的商品
	 * @param ids
	 */
	public void deleteManyProduct(String[] ids) throws SQLException {
		ProductDao dao = new ProductDao();
		for(String id : ids){
			dao.deleteProduct(id);
		}
	}

	/**
	 * 多条件查询
	 * @param pname
	 * @param keywords
	 * @return
	 */
	public List<Product> findProductByCondition(String pname, String keywords) throws SQLException {
		return new ProductDao().find(pname,keywords);
	}

	public PageBean<Product> showProductByPage(int currPage,int pageSize) throws SQLException {
		//get the elements
		ProductDao dao = new ProductDao();
		List<Product> list = dao.findProductByPage(currPage,pageSize);
		int totalCount = dao.getCount();


		return new PageBean<Product>(list,currPage,pageSize,totalCount);
	}
}
