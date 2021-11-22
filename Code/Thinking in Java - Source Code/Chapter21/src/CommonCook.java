public class CommonCook{

	public static void main(String[] args) throws InterruptedException{
		long start_time = System.currentTimeMillis();
		//网购刀具
		onlineShopping shopping = new onlineShopping();
		shopping.start();
		shopping.join();
		//去超市买食材
		Thread.sleep(2000);
		Food food = new Food();
		System.out.println("第二步：食材到位");
		//用刀具处理食材
		System.out.println("展现厨艺");
		cook(shopping.knife,food); //外部类通过创建实例访问内部类的变量
		System.out.println("总共用时：" + (System.currentTimeMillis() - start_time) + "ms");
	}
	static class onlineShopping extends Thread{
		private Knife knife;
		private long time = 5000;
		@Override
		public void run(){
			System.out.println("第一步：下单");
			System.out.println("第一步：等待送货");
			try {
				Thread.sleep(time);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("第一步：快递送达");
			Knife knife = new Knife();
		}
	}
	static void cook(Knife knife, Food food){}
	static class Knife{}
	static class Food{}
}
