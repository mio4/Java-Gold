package testRejectThreadPool;

import java.util.concurrent.*;

public class RejectThreadPoolDemo {

	public static class MyTask implements Runnable{
		@Override
		public void run(){
			System.out.println(System.currentTimeMillis() + ":Thread ID " + Thread.currentThread().getId());
			try{
				Thread.sleep(100);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException{
		MyTask myTask = new MyTask();
		ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(10),
				Executors.defaultThreadFactory(), new RejectedExecutionHandler() {
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				System.out.println(r.toString() + "is discard");
			}
		});

		for(int i=0; i < Integer.MAX_VALUE; i++){
			es.submit(myTask);
			Thread.sleep(10);
		}
	}
}

