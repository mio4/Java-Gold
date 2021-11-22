package other.Thread.threadLocal;

class Bank{
    ThreadLocal<Integer> t = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue(){
            return 100;
        }
    };

    public int get(){
        return t.get();
    }

    public void set(){
        t.set(t.get()+10);
    }

}

class Transfer implements Runnable{
    private Bank bank;

    public Transfer(Bank bank){
        this.bank = bank;
    }

    @Override
    public void run(){
        for(int i=0; i < 10; i++){
            bank.set();
            System.out.println(Thread.currentThread() + " " + bank.get());
        }
    }
}

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        Transfer t = new Transfer(bank);
        Thread t1 = new Thread(t);
        t1.start();
        Thread t2 = new Thread(t);
        t2.start();
        t1.join();
        t2.join();
        System.out.println(bank.get());
    }
}
