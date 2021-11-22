package testTryAndFinally;

public class testTryAndFinally {
	public static void f(String name){
		try {
			name.length();
		} finally{
			System.out.println("!");
		}
	}

	public static void main(String[] args){
		String a = null;
		f(a);
	}

}
