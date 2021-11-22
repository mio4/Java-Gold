package MessageQueue_.Chap1_CreateMQ;

import java.util.concurrent.ArrayBlockingQueue;

public class Broker {

    private final static int MAX_SIZE = 3;
    private static ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<String>(MAX_SIZE);

    public static void produce(String msg){
        if(messageQueue.offer(msg)){ //ArrayBlockQueue.offer：1.数据没有满时，插入 2.数据满时，插入失败，返回false
            System.out.println("成功向消息中心投递消息 " + msg + ",当前暂存的消息总量为 " + messageQueue.size());
        }
        else{
            System.out.println("消息中心达到最大负荷，不能投递消息");
        }
        System.out.println("-------------------------------");
    }

    public static String consume(){
        String msg = messageQueue.poll(); //返回队列头部内容；如果队列为空，则返回null
        if(msg != null){
            System.out.println("已经消费消息 " + msg + "，当前暂存的消息总量为 " + messageQueue.size());
        }
        System.out.println("-------------------------------");
        return msg;
    }
}
