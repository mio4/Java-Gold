//Collection和Map是常用接口,Collection可实现的类有ArrayList、LinkedList、HashSet，Map可以实现的类有HashMap、TreeMap
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PrintContainers {
	static Collection fill(Collection<String> collection){
		collection.add("aaa");
		collection.add("bbb");
		collection.add("ccc");
		return collection;
	}
	static Map fill(Map<String,String> map){
		map.put("aaa","111");
		map.put("bbb","222");
		map.put("ccc","333");
		return map;
	}
	public static void main(String[] args){
		System.out.println(fill(new ArrayList<String>()));
		System.out.println(fill(new HashMap<String,String>()));
	}
}
