package com.mio4.web;

import java.text.MessageFormat;
import java.util.Date;


public class testSomething2 {
	public static void main(String[] args){
		//String d = new Date().toString();
		//System.out.println(d);
		int planet = 7;
		String event = "EVENT";
		String result = MessageFormat.format("[0] {1} [1] {1} [2] {0} {2}",planet,new Date(), event);
		System.out.println(result);
	}
}
