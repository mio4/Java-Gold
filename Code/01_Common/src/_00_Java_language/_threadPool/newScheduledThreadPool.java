package _00_Java_language._threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class newScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);
        for (int i = 0; i < 2; i++) {
            //每隔一秒执行一次
            pool.scheduleAtFixedRate(() -> {
                System.out.println(Thread.currentThread().getName() + "\t开始发车啦....");
            }, 1, 1, TimeUnit.SECONDS);
        }
    }
}