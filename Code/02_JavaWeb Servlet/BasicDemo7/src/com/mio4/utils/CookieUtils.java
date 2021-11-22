package com.mio4.utils;

import javax.servlet.http.Cookie;

public class CookieUtils {
	public static Cookie getCookieByName(String key, Cookie[] cookies){
		Cookie c = null;
		for(Cookie co : cookies){
			if(co.getName().equals(key))
				return co;
		}
		return c;
	}
}
