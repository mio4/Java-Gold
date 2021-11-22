//泛型接口
interface Generator<T>{
	T next();
}
//实现泛型接口的方式：传入具体参数
public class Fibonacci implements Generator<Integer>{
	private int count = 0;
	public Integer next(){
		return fib(count++);
	}
	private int fib(int n){
		if(n < 2) return 1;
		return fib(n-2)+fib(n-1);
	}

	public static void main(String[] args){
		Fibonacci gen = new Fibonacci();
		for(int i=0;i < 10;i++){
			System.out.println(gen.next());
		}

		//Java SE5编译器的自动打包和拆包
		Integer a = 100;
		Integer b = 100;
		System.out.println(a==b);
		Integer c = 1000;
		Integer d = 1000;
		System.out.println(c==d);
	}
}
