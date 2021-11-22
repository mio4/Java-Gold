package notes.PlusB;

class Runner extends Thread{
    private volatile boolean quit = false;

    public void run(){
        while(!quit){
            System.out.println("*");
        }
        System.out.println("Done");
    }

    public void shutdown(){
        quit = true;
    }
}

public class Bmain {
    public static void main(String[] args){
        Runner runner = new Runner();
        runner.run();
        runner.shutdown();
    }
}
