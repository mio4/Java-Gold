package testAutomic;

public class TestAutomic {
	public static long t = 0;

	public static class ChangeT implements Runnable{ //为什么要使用静态内部类？ 可以单独初始化
		private long to;
		public ChangeT(long to){
			this.to = to;
		}

		@Override
		public void run(){
			while(true){
				TestAutomic.t = to;
				Thread.yield();
			}
		}
	}

	public static class ReadT implements Runnable{
		@Override
		public void run(){
			while(true){
				long tmp = TestAutomic.t;
				if(tmp!=111L && tmp!=-999L && tmp!=333L && tmp!=-444L)
					System.out.println(tmp);
				Thread.yield();
			}
		}
	}

	public static void main(String[] args){
		new Thread(new TestAutomic.ChangeT(111L)).start();
		new Thread(new TestAutomic.ChangeT(-999L)).start();
		new Thread(new TestAutomic.ChangeT(333L)).start();
		new Thread(new TestAutomic.ChangeT(-444L)).start();
		new Thread(new TestAutomic.ReadT()).start();

	}
}
