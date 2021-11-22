package _01_Algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @param <K> Key——物理页号
 * @param <V> Value——存储的具体值
 */
class Node<K,V>{
    private K key;
    private V value;
    Node<K,V> before;
    Node<K,V> next;

    public Node(){

    }

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

}

/**
 * 需要维护两个数据结构：（1）cacheMap （2）双向链表
 * cacheMap是通过双向链表的变化来保证是否需要删除entry...
 * @param <K>
 * @param <V>
 */
public class LRU<K,V> {
    private final Map<K,V> cacheMap = new HashMap<>();
    private int cacheSize; //最大缓存大小
    private int nodeCount; //节点大小
    private Node<K,V> header; //头节点
    private Node<K,V> tailer; //尾节点

    public LRU(int cacheSize){
        this.cacheSize = cacheSize;
        header = new Node<>();
        header.before = null;

        tailer = new Node<>();
        tailer.next = null;

        header.next = tailer;
        tailer.before = header;
    }

    public void put(K key,V value){
        cacheMap.put(key,value);
        addNode(key,value); //双向链表添加节点
    }

    public V get(K key){
        Node<K,V> node = getNode(key); //获取该节点
        moveToHead(node);  //节点移动到链表头部
        return cacheMap.get(key);
    }

    //辅助函数
    public Node<K,V> getNode(K key){
        Node<K,V> t = header;
        while(t != null){
            if(t.getKey().equals(key)){
                return t;
            }

            t = t.next;
        }
        return null;
    }

    public void moveToHead(Node<K,V> node){
        //1.删除原有节点
        //如果本来是尾部节点
        if(node.next == null){
            node.before.next = null;
            tailer = node.before;
            nodeCount--;
        }
        //如果本来是头部节点
        if(node.before == null){
            return;
        }
        //如果是中间节点
        if(node.next != null && node.before != null){
            node.before.next = node.next;
            node.next.before = node.before;
            nodeCount--;
        }

        //2.在头部添加原有节点
        addNode(node.getKey(),node.getValue());
    }

    public void addNode(K key,V value){ //链表添加节点
        Node<K,V> node = new Node<>(key,value);

        //1.判断hashMap容量：如果容量满了，删除尾节点
        if(cacheSize == nodeCount){
            delTail();
        }

        //2.添加头节点
        header.before = node;
        node.next = header;
        header = node;
        nodeCount++;
        //FIXME some more
    }


    private void delTail(){ //删除尾节点
        cacheMap.remove(tailer.getKey());

        tailer.before.next = null;
        tailer = tailer.before;
    }

}
