package notes.Chap0;

public class Printer implements Runnable{
    private String message;
    public Printer(String message){
        this.message = message;
    }

    @Override
    public void run(){
        for(int i=0; i < 10000; i++){
            System.out.println(message);
        }
    }

    public static void main(String[] args){
        new Thread(new Printer("Good!")).start();
        new Thread(new Printer("Nice!")).start();
    }
}
