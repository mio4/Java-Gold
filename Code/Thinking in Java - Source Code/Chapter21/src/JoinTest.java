public class JoinTest {

	public static void main(String[] args) throws InterruptedException{
		joinTestThread t1 = new joinTestThread("me");
		joinTestThread t2 = new joinTestThread("you");
		t1.start();
		t1.join(1); //放弃主线程的执行，直到t1执行完之后，才将cpu控制权给主线程
		t2.start();
	}
}
class joinTestThread extends Thread {
	public joinTestThread(String name){ //线程的名称
		super(name);
	}
	@Override
	public void run(){
		for(int i=0;i < 100; i++){
			System.out.println(this.getName() + ":" + i);
		}
	}
}
