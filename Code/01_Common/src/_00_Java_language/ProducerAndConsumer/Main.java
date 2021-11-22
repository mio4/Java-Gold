package _00_Java_language.ProducerAndConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//1. 首先创建一个生产者类
class Producer implements Runnable {
    private BlockingQueue blockingQueue;

    public Producer(BlockingQueue blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                blockingQueue.put(1);
                System.out.println(Thread.currentThread().getName()
                        + "生产者生产，目前总共有" + blockingQueue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//2. 然后创建一个消费者类
class Consumer implements Runnable {
    private BlockingQueue blockingQueue;

    public Consumer(BlockingQueue blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            try {
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName()
                        + "消费者消费，目前总共有" + blockingQueue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    //创建一个阻塞队列
    private static BlockingQueue blockingQueue = new ArrayBlockingQueue<>(10);
    public static void main(String[] args) {
        new Thread(new Producer(blockingQueue)).start();
        new Thread(new Producer(blockingQueue)).start();
        new Thread(new Producer(blockingQueue)).start();
        new Thread(new Producer(blockingQueue)).start();
        new Thread(new Consumer(blockingQueue)).start();
        new Thread(new Consumer(blockingQueue)).start();
        new Thread(new Consumer(blockingQueue)).start();
        new Thread(new Consumer(blockingQueue)).start();
    }

}