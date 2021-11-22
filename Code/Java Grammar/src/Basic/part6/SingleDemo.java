package Basic.part6;

/**
 * 单例模式
 * 1.目的：单例模式确保某个类只有一个实例，而且自行实例化并向整个系统提供这个实例。在计算机系统中，线程池、缓存、日志对象、对话框、打印机、显卡的驱动程序对象常被设计成单例。
 * 2.设计：
 * （1）禁止其他程序建立对象
 * （2）...
 * （3）对外提供访问方式
 */

//饿汉式
/*class Single{
	public int num; //成员变量
	private static Single s = new Single(); //类变量

	*//**
	 * 构造方法私有化
	 *//*
	private Single(){

	}

	public void setNum(int num){
		this.num = num;
	}

	public static Single getInstance(){
		return s;
	}
}*/

//懒汉式
class Single{
	private static Single s = null;
	private Single(){

	}

	public static Single getInstance(){
		if(s == null)
			s = new Single();
		return s;
	}
}



public class SingleDemo {
	public static void main(String[] args){
		Single s = Single.getInstance();
		Single s1 = Single.getInstance();
		Single s2 = Single.getInstance();
		//s1.setNum(10);
		//System.out.println(s2.num); //s1和s2指向相同的对象
	}
}
