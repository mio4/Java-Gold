package Proxy;

/**
 * 学生代理类，保留了一个学生实体，这样就可以调用实体的方法
 */
public class StudentProxy implements Person{
	Student stu;

	public StudentProxy(Person stu){
		//只代理学生对象
		if(stu.getClass() == Student.class){
			this.stu = (Student) stu;
		}
	}

	//代理学生的交班费行为
	public void giveMoney(){
		//附加行为
		System.out.println("mio is in progress!");

		stu.giveMoney();
	}
}
