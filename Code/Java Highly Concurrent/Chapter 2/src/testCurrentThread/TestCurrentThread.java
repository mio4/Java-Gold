package testCurrentThread;

class MyThread extends Thread{
	@Override
	public void run(){
		try {
			Thread.sleep(500);
			Thread t = Thread.currentThread();
			System.out.println("CurrentThread 当前线程名称" + t.getName() + ",当前线程优先级" + t.getPriority() + ",ID:" + t.getId());
			System.out.println("This 当前线程名称" + this.getName() + ",当前线程优先级" + this.getPriority() + ",ID:" + this.getId());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

public class TestCurrentThread {
	public static void main(String[] args){
		MyThread mt = new MyThread();
		new Thread(mt,"name1").start();
		new Thread(mt,"name2").start();
		new Thread(mt,"name3").start();
		System.out.println("***");
		//System.out.println(Thread.currentThread().getName()); //获取当前进程的名称
	}

}
