package com.mio4.web.dao;

import com.mio4.web.domain.Product;
import com.mio4.web.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

	public List<Product> findAll() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product";

		//qr.query(String sql, ResultSetHandler)的返回值是一个封装好了的Bean集合
		List<Product> tmp = qr.query(sql,new BeanListHandler<>(Product.class));

		//return qr.query(sql,new BeanListHandler<>(Product.class));
		return tmp;
	}

	public void addProduct(Product p) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		/*
			create table `product` (
			`pid` varchar (96),
			`pname` varchar (150),
			`market_price` double ,
			`shop_price` double ,
			`pimage` varchar (600),
			`pdate` date ,
			`pdesc` varchar (765)
		);
		 */
		String sql = "insert into product (pid,pname,market_price,shop_price,pdate,pdesc) values (?,?,?,?,?,?)";
		qr.update(sql,p.getPid(),p.getPname(),p.getMarket_price(),
			p.getShop_price(),p.getPdate(),p.getPdesc()
		);

	}

	public Product getProductById(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pid = ?";
		return qr.query(sql, new BeanHandler<>(Product.class),pid);
	}

	public void editProduct(Product p) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update product set pname = ?, market_price = ?, shop_price = ?, pdesc = ? where pid = ?";
		qr.update(sql,p.getPname(),p.getMarket_price(),p.getShop_price(),p.getPdesc(),p.getPid());
	}

	public void deleteProduct(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from product where pid = ?";
		qr.update(sql,pid);
	}

	/**
	 *
	 * @param pname 商品名称
	 * @param keywords 关键词
	 * @return
	 */
	public List<Product> find(String pname, String keywords) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where 1=1 ";
		ArrayList<String> params = new ArrayList<String>(); //存放参数
		if(pname != null && pname.trim().length() > 0){
			sql += (" and pname like ? ");
			params.add("%" + pname + "%");
		}
		if(keywords != null && keywords.trim().length() > 0){
			sql += (" and pdesc like ? ");
			params.add("%" + keywords + "%");
		}
		return qr.query(sql,new BeanListHandler<>(Product.class),params.toArray());
	}

	/**
	 * 返回第currPage页的数据
	 * (n-1)*pageSize,pageSize
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public List<Product> findProductByPage(int currPage, int pageSize) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product limit ?,?";
		return qr.query(sql,new BeanListHandler<>(Product.class),(currPage-1)*pageSize,pageSize);
	}

	/**
	 *
	 * @return
	 */
	public int getCount() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from product;";
		return ((Long)qr.query(sql,new ScalarHandler())).intValue();
	}
}
