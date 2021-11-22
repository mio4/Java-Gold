package other.Thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试ReentrantLock
 */
public class ReentrantLockTest implements Runnable{

    private static ReentrantLock lock = new ReentrantLock();
    private static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            lock.lock();  // 看这里就可以
            try {
                i++;
            } finally {
                lock.unlock(); // 看这里就可以
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest test = new ReentrantLockTest();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.err.println(i);
    }
}
