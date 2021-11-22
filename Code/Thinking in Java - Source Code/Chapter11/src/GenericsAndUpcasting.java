import java.util.ArrayList;
//ArrayList虽然规定了泛型，但是能够存储类型参数的子类
class sonC1 extends Apple{}
class sonC2 extends Apple{}
class sonC3 extends Apple{}
class sonC4 extends Apple{}

public class GenericsAndUpcasting {
	public static void main(String[] args){
		ArrayList<Apple> apples = new ArrayList<Apple>();
		apples.add(new sonC1());
		apples.add(new sonC2());
		apples.add(new sonC3());
		apples.add(new sonC4());
		for(int i=0; i < apples.size();i++)
			System.out.println(apples.get(i));
	}
}
