package Basic.part14;
import java.util.*;

/**
 * 对于Collection的方法进行测试
 */
public class CollectionDemo {
	public static void main(String[] args){
		method_all();
	}

	/**
	 * retainAll
	 * removeAll
	 */
	public static void method_all(){
		ArrayList al1 = new ArrayList();
		al1.add("num1");
		al1.add("num2");
		al1.add("num3");
		al1.add("num4");

		ArrayList al2 = new ArrayList();
		al2.add("num3");
		al2.add("num4");
		al2.add("num5");
		al2.add("num6");

/*		System.out.println("before" + al1);
		al1.retainAll(al2);
		System.out.println("after" + al1);*/
		System.out.println("-------");
		System.out.println("before" + al1);
		al1.removeAll(al2);
		System.out.println("after" + al1);
	}

	/**
	 * Iterator
	 */
	public static void method_iter(){

	}
}
