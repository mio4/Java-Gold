package SomeLearning;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
public class Main {
	public static void main(String[] args){
		Animal dog = new Dog();
		//dog.move();
		//dog.move(1);
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("b");
		treeSet.add("c");
		treeSet.add("e");
		treeSet.add("a");
		Iterator<String> iter = treeSet.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
}
class Animal {
	public void move(){
		System.out.println("animals can move");
	}

	public void move(int i){
		System.out.println("move" + i);
	}
}
class Dog extends Animal{
	public void move(){
		super.move();
		System.out.println("dog can shout");
	}
}
