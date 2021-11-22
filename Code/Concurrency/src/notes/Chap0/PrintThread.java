package notes.Chap0;

public class PrintThread extends Thread{
    private String message;
    public PrintThread(String message){
        this.message = message;
    }

    @Override
    public void run(){
        for(int i=0; i < 1000; i++){
            System.out.println(message);
        }
    }

    public static void main(String[] args){
        new PrintThread("Good").start();
        new PrintThread("Nice").start();
    }
}


