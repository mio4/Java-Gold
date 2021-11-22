package notes.Chap2;

public class Dmain {
    private final static Long CALL_COUNT = 1000000000L;
    public static void main(String[] args){
        trial("NotSync",CALL_COUNT,new NotSync());
        trial("Sync",CALL_COUNT,new Sync());
    }

    private static void trial(String msg, long count, Object obj){
        System.out.println(msg + " begin");
        Long start_time = System.currentTimeMillis();
        for(long i=0; i < count; i++){
            obj.toString();
        }
        System.out.println(msg + " end");
        System.out.println("use " + (System.currentTimeMillis() - start_time) + " ms");
    }
}

class NotSync{
    private final String name = "NotSync";
    public String toString(){
        return "[" + name + "]";
    }
}

class Sync{
    private final String name = "Sync";
    public synchronized String toString(){
        return "[" + name + "]";
    }
}