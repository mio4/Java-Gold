package testReadWriteLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
	private static Lock lock = new ReentrantLock();
	private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private static Lock readLock = readWriteLock.readLock();
	private static Lock writeLock = readWriteLock.writeLock();
	private int val;

	public Object HandleRead(Lock lock) throws InterruptedException{
		try{
			lock.lock();
			Thread.sleep(1000); //模拟读操作耗时
			return val;
		} finally{
			lock.unlock();
		}
	}

	public void HandleWrite(Lock lock, int times) throws InterruptedException{
		try{
			lock.lock();
			Thread.sleep(1000); //模拟写操作耗时
			val = times;
		} finally{
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException{
		final ReadWriteLockDemo demo = new ReadWriteLockDemo();
		Runnable readRunnable = new Runnable() {
			@Override
			public void run() {
				try {
					//demo.HandleRead(readLock);
					demo.HandleRead(lock);
				} catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		};

		Runnable writeRunnable = new Runnable() {
			@Override
			public void run() {
				try{
					//demo.HandleWrite(writeLock,new Random().nextInt());
					demo.HandleWrite(lock,new Random().nextInt());
				} catch(Exception e){
					e.printStackTrace();
				}
			}
		};
		//开始模拟读写的过程
		for(int i=0; i < 18; i++){
			new Thread(readRunnable).start();
		}
		for(int i=18; i < 20; i++){
			new Thread(writeRunnable).start();
		}
	}
}
