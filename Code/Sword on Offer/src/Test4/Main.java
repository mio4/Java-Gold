package Test4;

public class Main {
	public static void main(String[] args){
		int i = 0;
		f(i--);
		System.out.println(i);
	}

	public static void f(int i){
		System.out.println(i);
	}
}
