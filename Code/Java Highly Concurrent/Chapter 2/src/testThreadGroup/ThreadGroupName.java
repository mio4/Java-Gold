package testThreadGroup;

public class ThreadGroupName extends Thread{
	@Override
	public void run(){
		String groupAndName = Thread.currentThread().getThreadGroup().getName() + "-" + Thread.currentThread().getName();
		while(true){
			System.out.println("I am " + groupAndName);
			try{
				Thread.sleep(2000);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws InterruptedException{
		ThreadGroup tg = new ThreadGroup("PrintGroup");
		Thread t1 = new Thread(tg,new ThreadGroupName(), "T1");
		Thread t2 = new Thread(tg,new ThreadGroupName(), "T2");
		t1.start();
		t2.start();
		System.out.println(tg.activeCount());
		tg.list();
	}
}
