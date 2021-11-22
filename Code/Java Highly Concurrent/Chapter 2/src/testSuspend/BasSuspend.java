package testSuspend;

public class BasSuspend {
	public static Object u = new Object();
	static ChangeObjectThread t1 = new ChangeObjectThread("t1");
	static ChangeObjectThread t2 = new ChangeObjectThread("t2");

	public static class ChangeObjectThread extends Thread{
		public ChangeObjectThread(String name){
			super.setName(name);
		}
		@Override
		public void run(){
			synchronized(u){
				//System.out.println("in " + getName());
				System.out.println("in " + Thread.currentThread().getName());
				Thread.currentThread().suspend();
			}
		}
	}
	public static void main(String[] args) throws InterruptedException{
		t1.start();
		Thread.sleep(200);
		t2.start();
		t1.resume();
		t2.resume();
		t1.join();
		t2.join();
	}
}
