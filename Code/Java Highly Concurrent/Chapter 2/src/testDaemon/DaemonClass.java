package testDaemon;

public class DaemonClass extends Thread{
	@Override
	public void run(){
		while(true) {
			System.out.println("me");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException{
		Thread t = new DaemonClass();
		//t.setDaemon(true);
		t.start();
		Thread.sleep(3000);
	}
}
