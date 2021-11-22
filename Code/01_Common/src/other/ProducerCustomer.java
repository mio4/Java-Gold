package other;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 使用阻塞队列使用生产者-消费者队列模型
 * （1）当队列为空的时候，试图从队列中取元素的操作阻塞
 * （2）当队列为满的时候，试图从队列中添加元素的操作阻塞
 * ArrayBlockingQueue：put()和take()操作
 */
public class ProducerCustomer {
    private static final int queueSize = 5;
    private static final ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(queueSize);
    private static final int produceSpeed = 2000;
    private static final int consumeSpeed = 10;

    public static class Producer implements Runnable{

        @Override
        public void run() {
            while(true){
                try {
                    queue.put("一根油条");
                    System.out.println("往架子上放了一根油条：" + queue.size());
                    Thread.sleep(produceSpeed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static class Consumer implements Runnable{

        @Override
        public void run() {
            while(true){
                try {
                    queue.take();
                    System.out.println("A买了一根油条，架子上剩下的油条数量：" + queue.size());
                    Thread.sleep(consumeSpeed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());
        producer.start();
        consumer.start();
    }
}
