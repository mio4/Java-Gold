package com.mio4.datasource;

public class NormalCar implements Car{
	@Override
	public void run(){
		System.out.println("The car runs");
	}

	@Override
	public void stop(){
		System.out.println("The car stops");
	}
}
