package other;

import java.util.LinkedList;

/**
 * 手写一个生产者-消费者模型
 */
public class ProducerConsumer {
    private static int MAX_VALUE = 10;
    LinkedList<String> linkedList = new LinkedList<>();
    Object object = new Object();

    public void produce() throws Exception{
        synchronized(linkedList){
            if(MAX_VALUE == linkedList.size()){
                System.out.println("仓库已满，生产者：暂时不能执行任务");
                object.wait();
            }
            linkedList.push("product");
            System.out.println("生产者：生产了一个产品，储存量为:" + linkedList.size());
            linkedList.notifyAll();
        }
    }

    public void consumer() throws Exception{
        synchronized(linkedList){
            if(linkedList.size() == 0){
                System.out.println("仓库无货，消费者：暂时不能执行消费任务");
                linkedList.wait();
            }
            linkedList.pop();
            System.out.println("消费者：消费了一个产品， 储存量为：" + linkedList.size());
            linkedList.notifyAll();
        }
    }
}
