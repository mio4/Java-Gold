package other.Thread;

public class JoinTest {

    static class ThreadA extends Thread{
        public ThreadA(String name){
            super(name);
        }

        public void run(){
            System.out.printf("%s start\n", this.getName());
            for(int i=0; i < 1000000; i++); //模拟耗时操作
            System.out.printf("%s finish\n", this.getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadA ta = new ThreadA("ta");
        ta.start();
        ta.join();
        int a = 10;
        System.out.printf("%s finish\n", Thread.currentThread().getName());
        System.out.println(10);
    }
}
