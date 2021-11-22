//Iterator是Java中的迭代器
//Iterator iter = l.iterator() 变量申明
//hasNext()和next()方法
//类的iterator()方法返回的是Iterator<T>也就是T类型的迭代器
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class testIterator {
	public static void main(String[] args){
		List l = new ArrayList();
		l.add("aa");
		l.add("bb");
		l.add("cc");
		for(Iterator iter = l.iterator(); iter.hasNext();){
			String str = (String) iter.next();
			System.out.println(str);
		}

		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);

		Iterator<Integer> iterator = list.iterator(); //获取ArrayList类内部的一个迭代器
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
