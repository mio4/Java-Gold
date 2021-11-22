package XiaoZhao.GC;

/**
 * 假设1：
 * 引用计数法：无法解决两个对象互相引用时的垃圾回收
 */
public class ReferenceCountingGC {

    private Object instance = null;
    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args){
        ReferenceCountingGC objectA = new ReferenceCountingGC();
        ReferenceCountingGC objectB = new ReferenceCountingGC();

        objectA.instance = objectB;
        objectB.instance = objectA;

        objectA = null;
        objectB = null;

        System.gc();
    }
}
