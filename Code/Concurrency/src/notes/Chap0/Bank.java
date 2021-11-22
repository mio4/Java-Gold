package notes.Chap0;

public class Bank {
    private int money;
    private String name;

    public Bank(int money,String name){
        this.money = money;
        this.name = name;
    }

    public void deposit(int m){
        money += m;
    }

    public boolean withdraw(int m){
        if(money >= m){
            money -= m;
            check();
            return true;
        }
        else{
            return false;
        }
    }

    public void check(){
        if(money < 0){
            System.out.println("可用余额变为负数");
        }
    }
}

class ClientThread implements Runnable{
    private Bank bank;
    public ClientThread(Bank bank){
        this.bank = bank;
    }
    @Override
    public void run(){
        while(true){
            boolean ok = bank.withdraw(1000);
            if(ok){
                bank.deposit(1000);
            }
        }
    }
}

class BankTest{
    public static void main(String[] args){
        Bank bank = new Bank(1000,"bank");
        new Thread(new ClientThread(bank)).start();
        new Thread(new ClientThread(bank)).start();
    }
}
