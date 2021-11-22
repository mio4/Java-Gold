package other;
//其他页面置换算法参考：http://www.cnblogs.com/lzrabbit/p/3734850.html
import java.util.HashMap;
public class LRUCache<K,V> {

    private final int MAX_CACHE_SIZE;
    private Entry head;
    private Entry tail;
    private HashMap<K,Entry<K,V>> hashMap;

    public LRUCache(int cacheSize){
        MAX_CACHE_SIZE = cacheSize;
        hashMap = new HashMap<K,Entry<K,V>>();
    }

    public void put(K key,V value){
        Entry entry = getEntry(key);
        if(entry == null){
            if(hashMap.size() >= MAX_CACHE_SIZE){
                hashMap.remove(tail.key);
                removeLast();
            }
            entry = new Entry();
            entry.key = key;
        }
        entry.value = value;
        moveToFirst(entry);
        hashMap.put(key,entry);
    }

    public V get(K key){
        Entry<K,V> entry = getEntry(key);
        if(entry == null)
            return null;
        moveToFirst(entry);
        return entry.value;
    }

    public void remove(K key){
        Entry entry = getEntry(key);
        if(entry != null){
            if(entry.prev != null)
                entry.prev.next = entry.next;
            if(entry.next != null)
                entry.next.prev = entry.prev;
            if(entry == head)
                head = entry.next;
            if(entry == tail)
                tail = entry.prev;
        }
        hashMap.remove(key);
    }

    private void moveToFirst(Entry entry){
        if(entry == head)
            return;
        if(entry.prev != null)
            entry.prev.next = entry.next;
        if(entry.next != null)
            entry.next.prev = entry.prev;
        if(entry == tail)
            tail = tail.prev;

        if(head == null || tail == null){
            head = tail = entry;
            return;
        }

        entry.next = head;
        head.prev = entry;
        head = entry;
        entry.prev = null;
    }

    private void removeLast(){
        if(tail != null){
            tail = tail.prev;
            if(tail == null)
                head = null;
            else
                tail.next = null;
        }
    }

    static class Entry<K,V>{
        public Entry prev;
        public Entry next;
        public K key;
        public V value;
    }

    private Entry<K,V> getEntry(K key){
        return hashMap.get(key);
    }

}
