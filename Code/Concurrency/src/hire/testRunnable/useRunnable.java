package hire.testRunnable;

class Seller2 implements Runnable{
    private int ticket = 5;
    public void run(){
        while(ticket > 0){
            sellTicket();
        }
    }

    private synchronized void sellTicket(){
        System.out.println("current thread:" + Thread.currentThread() + " thread ticket = " + ticket);
        ticket--;
    }
}

public class useRunnable {
    public static void main(String[] args){
        Seller2 s = new Seller2();
        new Thread(s).start();
        new Thread(s).start();
    }
}
