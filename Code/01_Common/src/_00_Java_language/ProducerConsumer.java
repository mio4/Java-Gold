package _00_Java_language;

import java.util.LinkedList;
import java.util.Random;

class Storage {
    private int maxSize;
    private LinkedList<Integer> storage;

    public Storage(){
        maxSize = 10;
        storage = new LinkedList<>();
    }

    //往缓冲区插入一个元素
    public synchronized void add(){
        while(storage.size() == maxSize){
            try{
                this.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        int random = new Random().nextInt(1000);
        storage.add(random);
        System.out.println("Set:" + random + ",current size :" + storage.size());
        this.notifyAll();
    }

    //从缓冲区取出一个元素
    public synchronized void get(){
        while(storage.size() == 0){
            try{
                this.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.printf("Get: %d ,current size :%d \n",  storage.poll(),storage.size());
        this.notifyAll();
    }
}

class Producer implements Runnable{
    private Storage storage;
    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            storage.add();
        }
    }
}

class Consumer implements Runnable{
    private Storage storage;
    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            storage.get();
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        Storage storage = new Storage();

        Producer producer = new Producer(storage);
        Thread t1 = new Thread(producer);

        Consumer consumer = new Consumer(storage);
        Thread t2 = new Thread(consumer);

        t2.start();
        t1.start();
    }
}
