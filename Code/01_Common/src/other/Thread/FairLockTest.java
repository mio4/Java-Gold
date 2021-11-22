package other.Thread;

import java.util.concurrent.locks.ReentrantLock;

public class FairLockTest implements Runnable{
    //public static ReentrantLock lock = new ReentrantLock(true); 公平锁
    private static ReentrantLock lock = new ReentrantLock(); //非公平锁

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                System.err.println(Thread.currentThread().getName() + "获取到了锁！");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FairLockTest test = new FairLockTest();
        Thread t1 = new Thread(test, "线程1");
        Thread t2 = new Thread(test, "线程2");
        t1.start();t2.start();
    }
}
