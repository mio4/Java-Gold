package testReenterLock;

import java.util.concurrent.locks.ReentrantLock;

public class FairLock implements Runnable{
	public static ReentrantLock fairLock = new ReentrantLock(false ); //公平锁

	@Override
	public void run(){
		while(true) {
			try {
				fairLock.lock();
				System.out.println(Thread.currentThread().getName() + " get the fair lock");
			} finally {
				fairLock.unlock();
			}
		}
	}

	public static void main(String[] args){
		FairLock r = new FairLock();
		Thread t1 = new Thread(r,"t1");
		Thread t2 = new Thread(r,"t2");
		t1.start();
		t2.start();
	}
}
