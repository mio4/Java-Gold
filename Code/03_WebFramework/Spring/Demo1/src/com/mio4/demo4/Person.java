package com.mio4.demo4;

public class Person {
	private String pname;
	private Car1 car1;

	public Person(String pname, Car1 car1) {
		this.pname = pname;
		this.car1 = car1;
	}

	@Override
	public String toString() {
		return "Person{" +
				"pname='" + pname + '\'' +
				", car1=" + car1 +
				'}';
	}
}
