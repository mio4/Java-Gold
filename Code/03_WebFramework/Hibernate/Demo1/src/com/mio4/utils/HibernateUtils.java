package com.mio4.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate框架的工具类
 */
public class HibernateUtils {
	private static final Configuration CONFIG;
	private static final SessionFactory FACTORY;

	static{
		//加载配置文件
		CONFIG = new Configuration().configure();
		FACTORY = CONFIG.buildSessionFactory();
	}

	public static Session getSession(){
		return FACTORY.openSession();
	}
}
