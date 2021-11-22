package testInterrupted;

class Me {
	public void me() throws InterruptedException{
		System.out.println("before");
		Thread.sleep(5000);
		System.out.println("before2");
	}

}

public class TestInterrupted {
	public static void main(String[] args) throws InterruptedException{
		/*System.out.println("before");
		Thread.sleep(1000);
		System.out.println("after");*/

		Me m = new Me();
		m.me();

	}

}
