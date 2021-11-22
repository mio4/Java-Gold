package notes.PlusB;

class Something{
    private int x = 0;
    private int y = 0;

    public void write(){
        this.x = 100;
        this.y = 50;
    }

    public void read(){
        if(x < y){
            System.out.println("x < y");
        }
    }
}
public class Main {
    public static void main(String[] args){
        final Something something = new Something();
        new Thread(){
            @Override
            public void run(){
                something.write();
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                something.read();
            }
        }.start();
    }
}
