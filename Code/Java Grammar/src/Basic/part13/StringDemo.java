package Basic.part13;

public class StringDemo {

	public static void main(String[] args){
		String s1 =  "mio";
		String s2 = new String("mio");
		String s3 = "mio";

		System.out.println(s1 == s2); //false
		System.out.println(s1.equals(s2)); //true
		System.out.println(s1 == s3); //true
	}
}
