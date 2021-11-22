//e.getStackTrace()获得栈轨迹，栈中存有元素
public class WhoCalled {
	static void f(){
		try {
			throw new Exception();
		} catch (Exception e){
			for(StackTraceElement ste : e.getStackTrace()){
				System.out.println(ste.getMethodName());
				//获取所有调用的方法名
			}
		}
	}
	static void g() {f();}
	static void h() {g();}
	public static void main(String[] args){
		f();
		System.out.println("--------");
		g();
		System.out.println("--------");
		h();
	}
}
