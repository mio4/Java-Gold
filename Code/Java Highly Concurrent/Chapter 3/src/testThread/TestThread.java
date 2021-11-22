package testThread;

public class TestThread extends Thread{
	private int tickets = 10;

	@Override
	public void run(){
		for(int i=0; i <= 100; i++){
			if(tickets > 0)
				System.out.println(Thread.currentThread().getName() + " 卖出票 " + tickets--);
		}
	}

	public static void main(String[] args){
		TestThread t1 = new TestThread();
		TestThread t2 = new TestThread();
		TestThread t3 = new TestThread();

		t1.start();
		t2.start();
		t3.start();
	}
}
