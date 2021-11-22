import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureCook {
	public static void main(String[] args) throws InterruptedException,ExecutionException {
		long start_time = System.currentTimeMillis();
		//网购厨具
		Callable<Knife> onlineShopping  = new Callable<Knife>(){
			@Override
			public Knife call() throws Exception{
				System.out.println("第一步：下单");
				System.out.println("第一步：等待送货");
				Thread.sleep(5000);
				System.out.println("快递送达");
				return new Knife();
			}
		};
		FutureTask<Knife> task = new FutureTask<Knife>(onlineShopping);
		new Thread(task).start();
		//第二步：去超市买食材
		Thread.sleep(2000);
		Food food = new Food();
		System.out.println("食材到位");
		//第三步：用厨具烹饪
		if(!task.isDone()){
			System.out.println("第三步：厨具未到，等待");
		}
		//Knife knife = new Knife();
		Knife knife = task.get();
		System.out.println("厨具到位");
		cook(knife,food);
		System.out.println("总共用时：" + (System.currentTimeMillis() - start_time) + "ms");
	}
	static void cook(Knife knife,Food food) {}
	static class Knife{}
	static class Food{}
}
