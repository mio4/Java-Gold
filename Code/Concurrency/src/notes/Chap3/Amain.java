package notes.Chap3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 电梯模型的基础
 */
class Request{
    private final String name;
    public Request(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return "[ Request " + name + " ]";
    }
}

class RequestQueue{
//    private final Queue<Request> queue = new LinkedList<Request>();
//    public synchronized Request getRequest(){
//        while(queue.peek() == null){
//            try{
//                wait();
//            } catch (InterruptedException e){
//
//            }
//        }
//        return queue.remove();
//    }
//
//    public synchronized void addRequest(Request request){
//        queue.add(request);
//        notifyAll();
//    }

    //实现java.util.concurrent包
    private final BlockingQueue<Request> queue = new LinkedBlockingDeque<Request>();
    public Request getRequest(){
        Request req = null;
        try{
            req = queue.take();
        } catch (InterruptedException e){}
        return req;
    }

    public void addRequest(Request request){
        try{
            queue.put(request);
        } catch (InterruptedException e) {}
    }
}



class ClientThread extends Thread{
    private final Random random;
    private final RequestQueue requestQueue;
    public ClientThread(RequestQueue requestQueue,String name, long seed){
        super(name);
        this.requestQueue = requestQueue;
        random = new Random(seed);
    }

    public void run(){
        for(int i=0; i < 10000; i++){
            Request request = new Request("No." + i);
            System.out.println(Thread.currentThread().getName() + " requests " + request);
            requestQueue.addRequest(request);
            try{
                Thread.sleep(random.nextInt(1000));
            } catch (Exception e){}
        }
    }
}

class ServerThread extends Thread{
    private final Random random;
    private final RequestQueue requestQueue;
    public ServerThread(RequestQueue requestQueue,String name, long seed){
        super(name);
        this.requestQueue = requestQueue;
        random = new Random(seed);
    }

    public void run(){
        for(int i=0; i < 10000; i++){
            Request request = requestQueue.getRequest();
            System.out.println(Thread.currentThread().getName() + " handles " + request);
            try{
                Thread.sleep(random.nextInt(1000));
            } catch (Exception e){}
        }
    }
}

public class Amain {
    public static void main(String[] args){
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue,"Alice",123456L).start();
        new ServerThread(requestQueue,"Rose",654321L).start();
    }
}















