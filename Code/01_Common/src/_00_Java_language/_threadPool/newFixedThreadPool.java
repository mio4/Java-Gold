package _00_Java_language._threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class newFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t开始发车啦....");
            });
        }
    }
}
