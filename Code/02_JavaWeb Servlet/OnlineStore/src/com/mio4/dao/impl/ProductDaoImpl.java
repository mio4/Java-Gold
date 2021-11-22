package com.mio4.dao.impl;

import com.mio4.dao.IProductDao;
import com.mio4.domain.PageBean;
import com.mio4.domain.Product;
import com.mio4.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;


public class ProductDaoImpl implements IProductDao {

	/**
	 * 查询最新商品
	 * @return
	 * @throws Exception
	 */
	public List<Product> findNew() throws Exception{
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product order by pdate limit 5";
		return qr.query(sql,new BeanListHandler<>(Product.class));
	}

	/**
	 * 查询最热商品
	 * @return
	 * @throws Exception
	 */
	public List<Product> findHot() throws Exception{
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where is_hot = 1 limit 5";
		return qr.query(sql,new BeanListHandler<>(Product.class));
	}

	/**
	 * 通过商品id获得商品
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	@Override
	public Product getByPid(String pid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pid = ? limit 1";
		return qr.query(sql,new BeanHandler<>(Product.class),pid);
	}

	/**
	 * 查询当前页需要展示的数据
	 * @param currPage
	 * @param pageSize
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Product> findByPage(int currPage, int pageSize, String cid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where cid = ? limit ?,?";
		return qr.query(sql,new BeanListHandler<>(Product.class),cid,(currPage-1)*pageSize,pageSize);
	}

	/**
	 * 查询当前类别的总条数
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	@Override
	public int getTotalCount(String cid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from product where cid = ?";
		//return (int) qr.query(sql,new ScalarHandler(),cid);
		return ((Long)qr.query(sql, new ScalarHandler(), cid)).intValue();
	}


}
