package _00_Java_language._1_MultiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayBlockingQueue<T> {
    private Lock lock = new ReentrantLock();
    private Object[] item;
    private int addIndex,getIndex,count;
    private Condition getCondition = lock.newCondition();
    private Condition addCondition = lock.newCondition();

    public ArrayBlockingQueue(int size){
        this.item = new Object[size];
    }

    public void add(T t){
        lock.lock();
        try{
            System.out.println("正在ADD对象 " + t);
            while(count == item.length){
                System.out.println("队列已满，阻塞ADD线程");
                addCondition.await();
            }
        //队列未满，添加元素，计数器加1
        item[addIndex++] = t;
        count++;
        //如果ADD指针指向末尾，那么重置
        if(addIndex == item.length) addIndex = 0;
        System.out.println("唤醒GET线程");
        getCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T get(){
        lock.lock();
        T t = null;
        try{
            while(count == 0){
                System.out.println("队列空了，阻塞GET线程");
                getCondition.await();
            }
            //队列没空
            t = (T) item[getIndex++];
            System.out.println("正在GET对象 " + t);
            count--;
            if(getIndex == item.length) getIndex = 0;
            System.out.println("唤醒ADD线程");
            addCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        final ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i < 3; i++)
                    queue.add(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i < 3; i++){
                    queue.get();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
