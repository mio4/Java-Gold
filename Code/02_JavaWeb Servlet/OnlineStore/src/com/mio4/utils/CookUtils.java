package com.mio4.utils;

import javax.servlet.http.Cookie;

public class CookUtils {
	/**
	 * 通过名称在cookie数组获取指定的cookie
	 * @param name cookie名称
	 * @param cookies  cookie数组
	 * @return
	 */
	public static Cookie getCookieByName(String name, Cookie[] cookies) {
		if(cookies!=null){
			for (Cookie c : cookies) {
				//通过名称获取
				if(name.equals(c.getName())){
					//返回
					return c;
				}
			}
		}
		return null;
	}
}
