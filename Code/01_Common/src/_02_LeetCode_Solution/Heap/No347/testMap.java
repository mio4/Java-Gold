package _02_LeetCode_Solution.Heap.No347;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class testMap {

    @Test
    public void testMap(){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Set entries = map.entrySet();
        Iterator iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    @Test
    public void testTreeMap(){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);
        map.put(5,5);
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            int key = (int) entry.getKey();
            int value = (int) entry.getValue();
            System.out.println(key + ":" + value);
        }
    }
}
