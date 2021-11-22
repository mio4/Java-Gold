package testThread;

public class TestThread {
	public static void main(String[] args){
		Thread t1 = new Thread(){
			@Override
			public void run(){
				System.out.println("使用匿名内部类创建线程");
			}
		};
		t1.start();
	}



}
