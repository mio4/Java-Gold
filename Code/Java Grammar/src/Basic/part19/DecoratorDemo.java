package Basic.part19;

/**
 * 装饰者模式
 */
class Person{
	public void eat(){
		System.out.println("person eat rice");
	}
}

class DecPerson{
	private Person person;
	DecPerson(Person person){
		this.person = person;
	}
	public void DecEat(){
		System.out.println("do some drinking");
		person.eat();
		System.out.println("wash hands");
	}
}

public class DecoratorDemo {

	public static void main(String[] args){

	}
}
