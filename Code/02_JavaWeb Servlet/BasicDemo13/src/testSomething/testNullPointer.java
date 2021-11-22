package testSomething;

public class testNullPointer {

	public static void main(String[] args){
		Object o = null;
		String s1 = (String) o;
		System.out.println(s1);
		//String s2 = o.toString();
	}
}
