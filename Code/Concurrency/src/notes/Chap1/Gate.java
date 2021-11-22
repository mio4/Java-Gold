package notes.Chap1;

public class Gate {
    private int counter = 0;
    private String name;
    private String address;

    public synchronized void pass(String name,String address){
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

    public String toString(){
        return ("No." + this.counter + "|name:" + this.name + " |address:" + this.address);
    }

    public void check(){
        if(name.charAt(0) != address.charAt(0)){
            System.out.println("***WARNING***" + toString());
        }
    }

    public static void main(String[] args){
        System.out.println("Testing gate~");
        Gate gate = new Gate();
        UserThread userThread1 = new UserThread(gate,"Alice","Alaska");
        userThread1.start();
        UserThread userThread2 = new UserThread(gate,"Bobby","Brazil");
        userThread2.start();
        UserThread userThread3 = new UserThread(gate,"Chris","Canada");
        userThread3.start();
    }
}

class UserThread extends Thread {
    private final Gate gate;
    private final String myName;
    private final String myAddress;

    public UserThread(Gate gate, String name, String address) {
        this.gate = gate;
        this.myName = name;
        this.myAddress = address;
    }

    @Override
    public void run() {
        System.out.println("Begin:");
        while (true) {
            gate.pass(this.myName, this.myAddress);
        }
    }
}

