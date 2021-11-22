package testThread;

public class testRunnable implements Runnable{
	private int tickets = 10;

	@Override
	public void run(){
		for(int i=0; i <= 100; i++){
			if(tickets > 0)
				System.out.println(Thread.currentThread().getName() + " 卖出票 " + tickets--);
		}
	}

	public static void main(String[] args){
		testRunnable tr = new testRunnable();
		Thread t1 = new Thread(tr,"窗口一");
		Thread t2 = new Thread(tr,"窗口二");
		Thread t3 = new Thread(tr,"窗口三");

		t1.start();
		t2.start();
		t3.start();
	}
}
