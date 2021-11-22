package other;

public class testLRUCache2 {
    public static void main(String[] args){
        //测试一下
        LRUCache2 cache2 = new LRUCache2(3);
        cache2.set("key1",7);
        cache2.set("key2",0);
        cache2.set("key3",1);
        cache2.set("key4",2);
        cache2.set("key2",0);
        //System.out.println(cache2.get("key1"));
        cache2.set("key5",3);
        //System.out.println(cache2.get("key2"));
        cache2.set("key2",0);
        cache2.set("key6",4);
    }
}
