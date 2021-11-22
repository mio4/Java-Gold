package Review;

import org.junit.Test;

import java.util.*;

public class test1 {

    @Test
    public void test1(){ //Set
        Set<String> set = new HashSet<String>();
        set.add(null);
        set.add(null);
        System.out.println(set.size());

        set.add("Hello");
        set.add("Hello");
        System.out.println(set.size());
        System.out.println(set.toString());
    }

    @Test
    public void test2(){
        HashMap hashMap = new HashMap();
        Map m = Collections.synchronizedMap(hashMap);
    }

    @Test
    public void test3(){
        Hashtable<String,String> hashTable = new Hashtable<String,String>();
        hashTable.put(null,null);
        System.out.println(hashTable.size());
    }

    @Test
    public void test4(){
        HashMap<String,String> hashMap = new HashMap<String,String>();
        hashMap.put(null,null);
        System.out.println(hashMap);
    }

    @Test
    public void test5(){ //测试iterator接口
        ArrayList<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println("before iterator " + list.toString());
        Iterator<String> iterator = list.iterator();
//        while(iterator.hasNext()){
//            String s = iterator.next();
//            if(s.equals("bbb"))
//                iterator.remove();
//        }
        //list.removeIf(s -> s.equals("bbb"));

//        while(iterator.hasNext()){
//            //System.out.println(iterator.next());
//            System.out.println("dead loop");
//        }

        while(iterator.hasNext()){
            iterator.remove();
            iterator.next();
        }
        System.out.println("after iterator " + list.toString());
    }


}
