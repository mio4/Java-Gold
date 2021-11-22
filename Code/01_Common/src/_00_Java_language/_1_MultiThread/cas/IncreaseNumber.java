package _00_Java_language._1_MultiThread.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class IncreaseNumber {
//    public static int number = 0;
    public static AtomicInteger number = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for(int i=0; i < 2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for(int j=0; j < 10000; j++){
//                        number++;
                        number.incrementAndGet();
                    }
                }
            }).start();
        }

        Thread.sleep(1000);
        System.out.println(number);
    }
}
