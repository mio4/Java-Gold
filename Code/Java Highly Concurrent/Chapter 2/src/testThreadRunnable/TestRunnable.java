package testThreadRunnable;

public class TestRunnable implements Runnable{
	@Override
	public void run(){
		System.out.println("使用Runnable接口创建线程");
	}

	public static void main(String[] args){
		Thread t1 = new Thread(new TestRunnable());
		t1.start();
	}
}
