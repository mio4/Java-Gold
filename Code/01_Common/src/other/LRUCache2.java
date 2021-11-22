package other;

import java.util.Hashtable;

/**
 * 能够手写的LRU算法
 * （1）节点的删除操作：不仅要在链表中删除，还需要在Hashtable中删除
 * （2）节点的增加操作：不仅要在链表中增加，还需要在Hashtable中添加
 * 手写代码尽量做到工整规范
 */

class DLinkedNode{
    String key;
    int value;
    DLinkedNode pre;
    DLinkedNode post;

    public DLinkedNode(){

    }

    public DLinkedNode(String key, int value){
        this.key = key;
        this.value = value;
    }
}
public class LRUCache2 {
    private static Hashtable<String,DLinkedNode> cache = new Hashtable<String,DLinkedNode>();
    private static int count;
    private static int capacity;
    private static DLinkedNode head,tail;

    public LRUCache2(int capacity){
        this.count = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.pre = null;
        head.post = tail;
        tail.pre = head;
        tail.post = null;
    }

    public static int get(String key){
        DLinkedNode node = cache.get(key);
        if(node == null)
            return -1;
        moveToHead(node);
        return node.value;
    }

    public static void set(String key,int value){
        DLinkedNode node = cache.get(key);
        if(node == null){
            DLinkedNode newNode = new DLinkedNode(key,value);
            cache.put(key,newNode);
            addNode(newNode);
            count++;
            if(count > capacity){
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                count--;
            }
        }
        else{
            node.value = value;
            moveToHead(node);
        }
    }

    public static void addNode(DLinkedNode node){
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }

    public static void removeNode(DLinkedNode node){
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    public static void moveToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }

    public static DLinkedNode popTail(){
        DLinkedNode res = tail.pre;
        removeNode(res);
        return res;
    }

}
