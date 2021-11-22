package com.mio4.service.impl;

import com.mio4.dao.ICategoryDao;
import com.mio4.dao.impl.CategoryDaoImpl;
import com.mio4.domain.Category;
import com.mio4.service.ICategoryService;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImpl implements ICategoryService {

	/**
	 * 查询所有的分类
	 * 1.在Service业务逻辑层进行缓存处理
	 * 2.对Bean进行序列化操作
	 * 使用Ehcache缓存
	 * @return
	 */
	@Override
	public List<Category> findAll() throws SQLException {
		/*
		(1) 没有使用缓存的方法
		ICategoryDao dao = new CategoryDaoImpl();
		return dao.findAll();*/

		//(2)使用缓存
		//1.创建缓存管理器
		CacheManager cacheManager = CacheManager.create(CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml"));
		//2.获取指定缓存
		Cache cache =  cacheManager.getCache("categoryCache");
		//3.通过Cache获取数据
		Element element = cache.get("clist");
		List<Category> list = null;
		if(element == null){
			ICategoryDao dao = new CategoryDaoImpl();
			list = dao.findAll();
			cache.put(new Element("clist",list));
			System.out.println("从数据库获取的Category");
		} else{
			list = (List<Category>) element.getObjectValue();
			System.out.println("从缓存中获取的Category！");
		}

		return list;
	}

	/*public static void main(String[] args){
		获取classes目录下的文件
		InputStream s = CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml");
		System.out.println(s);
	}*/

}
