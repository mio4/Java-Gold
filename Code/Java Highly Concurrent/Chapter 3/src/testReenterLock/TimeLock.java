package testReenterLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TimeLock implements Runnable{
	public static ReentrantLock lock = new ReentrantLock();

	@Override
	public void run(){
		try {
			if (lock.tryLock(5, TimeUnit.SECONDS)) {
				System.out.println(Thread.currentThread().getName() + "get the lock!");




				Thread.sleep(6000);
			} else {
				System.out.println(Thread.currentThread().getName() + "get lock failed");
			}
		} catch(InterruptedException e){
			e.printStackTrace();
		} finally{
			if(lock.isHeldByCurrentThread())
				lock.unlock();
		}
	}
	public static void main(String[] args){
		TimeLock t = new TimeLock();
		Thread t1 = new Thread(t);
		t1.setName("one");
		Thread t2 = new Thread(t);
		t2.setName("Two");
		t1.start();
		t2.start();
	}
}
