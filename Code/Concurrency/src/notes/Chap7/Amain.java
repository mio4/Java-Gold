package notes.Chap7;

class Host{
    private final Helper helper = new Helper();
    public void request(final int count, final char c){
        System.out.println("    request(" + count + ", " + c +") BEGIN");
        new Thread(){
            @Override
            public void run(){
                helper.handle(count,c);
            }
        }.start();
        System.out.println("    request(" + count + ", " + c +") END");
    }
}

class Helper{
    public void handle(int count, char c){
        System.out.println("    handle(" + count + ", " + c +") BEGIN");
        for(int i = 0; i < count; i++){
            slowly();
            System.out.println(c);
        }
        System.out.println("    handle(" + count + ", " + c +") END");
    }

    private void slowly(){
        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {}
    }
}

public class Amain {
    public static void main(String[] args){
        System.out.println("MAIN BEGIN");
        Host host = new Host();
        host.request(10,'A');
        host.request(20,'B');
        host.request(30,'C');
        System.out.println("MAIN END");
    }
}
