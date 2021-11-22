package testVolatile;

public class TestVolatile {
	public volatile static int i = 0;
	public static class PlusTask extends Thread{
		@Override
		public void run(){
			for(int k=0; k < 10000; k++)
				i++;
		}
	}

	public static void main(String[] args) throws InterruptedException{
		Thread[] ts = new Thread[10];
		for(int k=0; k < 10 ;k++){
			ts[k] = new Thread(new PlusTask());
			ts[k].start();
		}
		for(int k=0; k < 10; k++)
			ts[k].join();
		System.out.println(i);
	}
}
