package testReenterLock;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterLock extends Thread{
	public static ReentrantLock lock = new ReentrantLock();
	public static int i = 0;

	@Override
	public void run(){
		for(int j=0; j < 1000000; j++){
			lock.lock();
			try{
				i++;
			} finally{
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException{
		ReenterLock t = new ReenterLock();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);
	}
}




