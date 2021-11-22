//泛型方法
public class GenericMethod {
	public <T> void f(T x){ //<T>表示这是一个泛型方法
		System.out.println(x.getClass());
	}
	public static void main(String[] args){
		GenericMethod gm = new GenericMethod();
		gm.f(1);
		gm.f("string");
		gm.f(1.2);
		gm.f('c');
	}
}
