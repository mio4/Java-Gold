package Test2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class testHashMap {
	public static void main(String[] args){
		HashMap<String,String> hashMap = new HashMap<String,String>();
		hashMap.put("cn","中国");
		hashMap.put("jp","日本");
		hashMap.put("fr","法国");

		System.out.println(hashMap);
		System.out.println("******");
		System.out.println("cn:" + hashMap.get("cn"));
		System.out.println(hashMap.containsKey("cn"));

		System.out.println(hashMap.keySet());
		System.out.println(hashMap.isEmpty());
		hashMap.remove("cn");
		System.out.println(hashMap);

		Iterator it = hashMap.keySet().iterator();
		while(it.hasNext()){
			String key = (String)it.next();
			System.out.println("key: " + key);
			System.out.println("value: " + hashMap.get(key));
		}
		//遍历hashMap的另外一种方式
		Set<Entry<String,String>> sets = hashMap.entrySet();
		for(Entry<String,String> entry : sets){
			System.out.println(entry.getKey() + "," + entry.getValue());
		}
	}
}
