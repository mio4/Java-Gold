package notes.Chap1;

import java.util.Random;
import java.util.concurrent.Semaphore;

class Log{
    public static void println(String s){
        System.out.println(Thread.currentThread().getName() + ":" + s);
    }
}

class BoundedResource{
    private final Semaphore semaphore;
    private final int permits;
    private final static Random random = new Random(123456);

    public BoundedResource(int permits){
        this.semaphore = new Semaphore(permits);
        this.permits = permits;
    }

    public void use() throws InterruptedException{
        semaphore.acquire();
        try{
            doUse();
        } finally {
            semaphore.release();
        }
    }

    protected void doUse() throws InterruptedException{
        Log.println("BEGIN: used = " + (permits - semaphore.availablePermits()));
        Thread.sleep(random.nextInt(500));
        Log.println("END: used = " + (permits - semaphore.availablePermits()));
    }
}

class SUserThread extends Thread{
    private final static Random random = new Random(456123);
    private final BoundedResource boundedResource;
    public SUserThread(BoundedResource resource){
        this.boundedResource = resource;
    }

    public void run(){
        try{
            while(true){
                boundedResource.use();
                Thread.sleep(random.nextInt(500));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SempMain {
    public static void main(String[] args){
        BoundedResource boundedResource = new BoundedResource(3);
        for(int i=0; i < 10; i++){
            new SUserThread(boundedResource).start();
        }
    }
}
