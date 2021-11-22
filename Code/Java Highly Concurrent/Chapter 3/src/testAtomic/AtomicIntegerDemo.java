package testAtomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
	static AtomicInteger i =  new AtomicInteger();
	public static class AddThread implements Runnable{
		@Override
		public void run(){
			for(int k=0; k < 1000; k++){
				i.incrementAndGet();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException{
		Thread[] ts = new Thread[10];
		for(int k=0; k < 10; k++){
			ts[k] = new Thread(new AddThread());
		}
		for(int k=0; k < 10; k++){
			ts[k].start();
		}
		for(int k=0; k < 10; k++){
			ts[k].join();
		}
		System.out.println(i);
	}
}
