package interfaces;

public class Employee implements Comparable<Employee>{
	private String name;
	private double salary;

	public Employee(String name, double salary){
		this.name = name;
		this.salary = salary;
	}

	public String getName(){
		return this.name;
	}

	public double getSalary(){
		return this.salary;
	}

	public void raiseSalary(double byPercent){
		double raise = salary * byPercent / 100;
		this.salary += raise;
	}

	public int compareTo(Employee other){ //Employee类必须实现Comparable接口的compareTo()方法
		return Double.compare(salary, other.salary);
	}
}
