import java.util.Random;

public class test_reflection {
	public static void main(String[] args) {
		Person p = new Person();
		Class c1 = p.getClass();
		//System.out.println(c1.getName() + " " + p.getName());

		Random generator = new Random();
		Class c2 = generator.getClass();
		//System.out.println(c2.getName());

		String className = "java.util.Random";
		try {
			Class c3 = Class.forName(className);
			//System.out.println(c3.getName());
		} catch (Exception e){

		}

		Class c4 = int.class;
		System.out.println(c4.getName());

		System.out.println(int[].class.getName());
		System.out.println(Double[].class.getName());
	}
}
class Person {
	String name;
	int age;

	public String getName(){
		return this.name;
	}
}
