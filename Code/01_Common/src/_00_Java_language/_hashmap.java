package _00_Java_language;

interface MyMap<K,V>{
    public V get(K k);
    public V put(K k, V v);
    public boolean containsKey(K k);

    //内部接口
    interface Entry<K,V>{
        public K getKey();
        public V getValue();
    }
}

class MyHashMap<K,V> implements MyMap<K,V>{
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; //初始化长度为16
    private static final float DEFAULT_LOAD_FACTOR = 0.75f; //默认负载因子

    private int defaultIniSize; //可设置的初始容量
    private float defaultLoadFactor; //可设置的负载因子
    private int entryUseSize; //当前已存入的元素数量
    private Entry<K,V>[] table = null;

    public MyHashMap(){
        this(DEFAULT_INITIAL_CAPACITY,DEFAULT_LOAD_FACTOR); //this关键词的作用?
    }

    public MyHashMap(int defaultInitialCapacity, float defaultLoadFactor){

    }


    @Override
    public V get(K k) {
        //TODO
        return null;
    }

    @Override
    public V put(K k, V v) {
        //1. 首先判断是否需要扩容
        if(entryUseSize >= defaultIniSize * defaultLoadFactor){
            //resize(2*defaultIniSize);
        }

        //2. 获取k应该放置在数组中的某个位置
        //int index = hash(k) & (defaultIniSize - 1);
        int index = 0;
        if(table[index] == null){ //3.1 如果没有发生hash冲突
            table[index] = new Entry(k,v,null);
            entryUseSize++;
        }
        else{ //3.2 如果发生了hash冲突
            Entry<K,V> entry = table[index];
            Entry<K,V> e = entry;
            V oldValue = null;
            while(e != null){
                if(k == e.getKey() || k.equals(e.getKey())){ //如果是存在的key，需要替换旧值
                    oldValue = e.getValue();
                    e.value = v;
                    return oldValue;
                }
                e = e.next;
            }
            table[index] = new Entry<K,V>(k,v,entry); //创建新的节点，在链表头部插入
            entryUseSize++;
        }

        return null;
    }

    @Override
    public boolean containsKey(K k) {
        return false;
    }


    //--------------------------定义Entry对象--------------------------
    class Entry<K,V> implements MyMap.Entry<K,V>{

        private K key;
        private volatile V value;
        private Entry<K,V> next;

        public Entry(){

        }

        public Entry(K key, V value, Entry<K,V> next){
            super();
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }
    }
}



public class _hashmap {

    public static void main(String[] args) {

    }
}
