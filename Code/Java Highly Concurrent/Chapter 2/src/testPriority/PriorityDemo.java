package testPriority;

public class PriorityDemo {
	public static class HighPriority extends Thread{
		static int count = 0;
		public void run(){
			while(true){
				synchronized(PriorityDemo.class){
					count++;
					if(count > 1000000){
						System.out.println("High Priority is complete");
						break;
					}
				}
			}
		}
	}

	public static class LowPriority extends Thread{
		static int count = 0;
		public void run(){
			while(true){
				synchronized(PriorityDemo.class){
					count++;
					if(count > 1000000){
						System.out.println("Low Priority is complete");
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException{
		Thread high = new HighPriority();
		high.setName("high");
		high.setPriority(Thread.MAX_PRIORITY);
		Thread low = new LowPriority();
		low.setName("low");
		low.setPriority(Thread.MIN_PRIORITY);
		high.start();
		low.start();

	}
}
