package testSemaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemapDemo implements Runnable{
	final Semaphore semap = new Semaphore(5);

	@Override
	public void run(){
		try{
			semap.acquire();
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getId() + " done!");
			semap.release();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		ExecutorService exec = Executors.newFixedThreadPool(20);
		final SemapDemo demo = new SemapDemo();
		for(int i=0; i < 20; i++){
			exec.submit(demo);
		}
	}
}
