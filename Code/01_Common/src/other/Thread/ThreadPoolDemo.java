package other.Thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

    @Test
    public void testCacheThreadPool(){
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for(int i=0 ; i < 10; i++){
            int index =  i;
            try {
                Thread.sleep(index * 1000);
            } catch (Exception e){}

            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });
        }
    }

    @Test
    public void testScheduleThreadPool(){
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 3 seconds");
            }
        },3, TimeUnit.SECONDS);
    }

    @Test
    public void testScheduleThreadPool2(){
        //do nothing here
    }

    @Test
    public void testFinal(){
        int i;
        for(i=0; i < 10; i++){
            final int x = i;
            System.out.println(x);
        }
    }

    @Test
    public void testDeclare(){
        int i = 10;
        System.out.println(i);
        int j = 20;
        System.out.println(j);
    }

    public static void main(String[] args){
//        ScheduledExecutorService scheduleThreadPool = Executors.newScheduledThreadPool(5);
//        scheduleThreadPool.schedule(new Runnable() {
//            public void run() {
//                System.out.println("delay 3 seconds");
//            }
//        }, 3, TimeUnit.SECONDS);

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    Thread.currentThread().setName("Thread i = " + index);
                    System.out.println(Thread.currentThread().getName() + " index = " + index);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.out.println("ssss");
                    }
                }
            });
        }
        singleThreadExecutor.shutdown();
        System.out.println("on the main thread...");
    }
}
