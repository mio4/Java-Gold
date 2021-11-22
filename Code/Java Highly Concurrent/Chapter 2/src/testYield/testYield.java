package testYield;

class Producer extends Thread{
	@Override
	public void run(){
		for(int i=0; i < 2000; i++){
			System.out.println("Producer " + i);
			try{
				Thread.sleep(1);
				Thread.yield();
			} catch(Exception e){

			}
		}
	}
}

class Consumer extends Thread{
	@Override
	public void run(){
		for(int i=0; i < 2000; i++){
			System.out.println("Consumer " + i);
			try{
				Thread.sleep(1);
				Thread.yield();
			} catch(Exception e){

			}
		}
	}
}

public class testYield {
	public static void main(String[] args){
		Thread producer = new Producer();
		Thread consumer = new Consumer();

		//producer.setPriority(Thread.MIN_PRIORITY);
		//consumer.setPriority(Thread.MAX_PRIORITY);


		producer.run();
		consumer.run();

	}

}
