package com.mio4.demo4;

import java.util.*;

/**
 * 关于集合的注入
 */
public class User {
	private String[] arr;
	private List<String> list;
	private Map[] map;
	private Properties pro;

	public void setArr(String[] arr) {
		this.arr = arr;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public void setMap(Map[] map) {
		this.map = map;
	}

	public void setPro(Properties pro) {
		this.pro = pro;
	}

	@Override
	public String toString() {
		return "User{" +
				"arr=" + Arrays.toString(arr) +
				", list=" + list +
				", map=" + Arrays.toString(map) +
				", pro=" + pro +
				'}';
	}
}
