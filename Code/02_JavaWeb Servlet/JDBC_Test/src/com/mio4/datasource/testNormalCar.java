package com.mio4.datasource;

public class testNormalCar {

	public static void main(String[] args){
		NormalCar nc = new NormalCar();
		nc.run();
		nc.stop();

		NormalCarWrap ncw = new NormalCarWrap(nc);
		ncw.run();
		ncw.stop();
	}
}
