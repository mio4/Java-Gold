package com.mio4.web;

public class TestSomething {
	public static void main(String[] args){
		String path = "123/download/1.JPG";
		String filename = path.substring(path.lastIndexOf("/")+1);
		System.out.println(filename);

	}
}
