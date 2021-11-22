package com.mio4.datasource;

public class NormalCarWrap implements Car{
	private Car car;

	public NormalCarWrap(Car car){
		this.car = car;
	}

	@Override
	public void run(){
		System.out.println("enhanced car!");
	}

	@Override
	public void stop(){
		System.out.println("enhanced car stop");
	}
}
