package com.mio4.web.ClassLoader;

import sun.net.spi.nameservice.dns.DNSNameService;

/**
 * 测试类加载器
 */
public class Demo {
	public static void main(String[] args){
		ClassLoader ap = Demo.class.getClassLoader();
		System.out.println(ap);
		ClassLoader c2 = DNSNameService.class.getClassLoader();
		System.out.println(c2);
		ClassLoader c3 = String.class.getClassLoader();
		System.out.println(c3);
	}
}
