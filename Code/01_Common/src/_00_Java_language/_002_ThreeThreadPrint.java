package _00_Java_language;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _002_ThreeThreadPrint {
    private static Lock lock=new ReentrantLock();
    private static int state=0;//通过state的值来确定是哪个线程打印

    static class ThreadA extends Thread{
        @Override
        public void run(){
            for (int i = 0; i <10 ; ) {
                try{
                    lock.lock();
                    while(state%3==0){// 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
                        System.out.print("A");
                        state++;
                        i++;
                    }
                }finally{
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadB extends Thread{
        @Override
        public void run(){
            for (int i = 0; i <10 ; ) {
                try{
                    lock.lock();
                    while(state%3==1){
                        System.out.print("B");
                        state++;
                        i++;
                    }
                }finally{
                    lock.unlock();
                }
            }
        }
    }


    static class ThreadC extends Thread{
        @Override
        public void run(){
            for (int i = 0; i <10 ; ) {
                try{
                    lock.lock();
                    while(state%3==2){
                        System.out.print("C");
                        state++;
                        i++;
                    }
                }finally{
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}
