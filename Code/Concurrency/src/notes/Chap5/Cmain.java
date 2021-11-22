package notes.Chap5;

/**
 * 测试Sleep方法被Interrupted方法打断操作
 *
 *
 *
 *
 */
class AliceThread implements Runnable{
    @Override
    public void run(){
        try{
            Thread.sleep(100000);

        } catch (InterruptedException e){
            System.out.println("interrupted by Bobby");
        }
    }
}

class BobboyThread implements Runnable{
    private Thread aliceThread;

    public void getAlice(Thread aliceThread){
        this.aliceThread = aliceThread;
    }

    @Override
    public void run(){
        aliceThread.interrupt();
    }
}

public class Cmain {

    public static void main(String[] args){
        AliceThread alice = new AliceThread();
        Thread aliceThread = new Thread(alice);
        aliceThread.start();

        BobboyThread bobboy = new BobboyThread();
        bobboy.getAlice(aliceThread);
        Thread bobboyThread = new Thread(bobboy);
        bobboyThread.start();
    }
}
