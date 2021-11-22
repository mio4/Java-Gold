package com.mio4.web.utils;

import java.util.Date;
import java.util.UUID;

public class UUIDUtils {

	public static String getId(){
		return UUID.randomUUID().toString();
	}


	/**
	 * 生成一个令牌
	 * @return
	 */
	public static String getToken(){
		return getId();
	}

	/* 测试UUID
	public static void main(String[] args){
		System.out.println(getId());
		System.out.println(getId().replace("-","").toUpperCase());
		System.out.println(new Date().toString());
	}
	*/
}
