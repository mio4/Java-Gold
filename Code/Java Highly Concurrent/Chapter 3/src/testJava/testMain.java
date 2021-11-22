package testJava;

public class testMain {

	public static void main(String[] args){
		int a = 1;
		changeA(a);
		System.out.println(a);

		Integer b = 1;
		changeA(b);
		System.out.println(b);

		Student s = new Student("name1");
		changeS(s);
		System.out.println(s.getName());

		String str = "String1";
		changeString(str);
		System.out.println(str);

		Student s2 = new Student("name2");
		changeStudent(s2);
		System.out.println(s2.getName());

	}

	public static void changeA(int a){
		a = 2;
	}

	public static void changeS(Student s){
		s.setName("name2");
	}

	public static void changeString(String s){
		s = "String2";
	}

	public static void changeStudent(Student s){
		s = new Student("changeStudent new");
	}
}

class Student{
	private String name;

	public Student(String name){
		this.name = name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

}
