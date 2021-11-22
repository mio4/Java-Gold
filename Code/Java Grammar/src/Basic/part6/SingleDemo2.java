package Basic.part6;

class Student{
	private int age;

	//单例设计模式约束
	private static Student s = new Student();
	private Student(){}
	public static Student getInstance(){
		return s;
	}

	public void setAge(int age){
		this.age = age;
	}

	public int getAge(){
		return this.age;
	}
}

public class SingleDemo2 {
	public static void main(String[] args){
		Student s1 = Student.getInstance();
		Student s2 = Student.getInstance();
	}
}
