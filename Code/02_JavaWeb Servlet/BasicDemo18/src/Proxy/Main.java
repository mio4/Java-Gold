package Proxy;

public class Main {
	public static void main(String[] args){
		Person s = new Student("mio");

		Person monitor = new StudentProxy(s);

		monitor.giveMoney();
	}
}
