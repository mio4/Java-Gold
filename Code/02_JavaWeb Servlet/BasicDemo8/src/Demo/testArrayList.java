package Demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class testArrayList {
	public static void main(String[] args){
		List list = new ArrayList<>();
		list.add("我");
		list.add(123);
		list.add(1.23);
		Iterator iter = list.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
}
