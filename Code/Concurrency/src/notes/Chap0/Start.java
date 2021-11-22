package notes.Chap0;

class MyThread extends Thread{
    @Override
    public void run(){
        for(int i=0; i < 10000; i++){
            System.out.println("Nice");
        }
    }
}

public class Start {
    public static void main(String[] args){
        MyThread myThread = new MyThread();
        myThread.start();
        //myThread.run();
        for(int i=0; i < 10000; i++){
            System.out.println("Good");
        }
    }
}
