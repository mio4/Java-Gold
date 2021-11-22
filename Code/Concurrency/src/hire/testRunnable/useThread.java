package hire.testRunnable;

class Seller extends Thread{
    private int ticket = 5;
    public void run(){
        while(true){
            System.out.println("thread ticket = " + ticket);
            ticket--;
            if(ticket < 0){
                break;
            }
        }
    }
}

public class useThread {
    public static void main(String[] args){
        new Seller().start();
        new Seller().start();
    }
}
