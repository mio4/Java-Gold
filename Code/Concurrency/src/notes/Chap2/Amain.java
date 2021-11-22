package notes.Chap2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class WriterThread extends Thread{
    private final List<Integer> list;

    public WriterThread(List<Integer> list){
        super("WriterThread");
        this.list = list;
    }

    public void run(){
        for(int i=0; true; i++){
            list.add(i);
            list.remove(0);
        }
    }
}

class ReaderThread extends Thread{
    private final List<Integer> list;
    public ReaderThread(List<Integer> list){
        super("ReaderThread");
        this.list = list;
    }

    public void run(){
        while(true){
//            synchronized (list) {
//                for (int n : list) {
//                    System.out.println(n);
//                }
//            }
            for(int n : list){
                System.out.println(n);
            }
        }
    }
}

public class Amain {

    public static void main(String[] args){
        //List<Integer> list = new ArrayList<Integer>();
        //final List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
        final List<Integer> list = new CopyOnWriteArrayList<Integer>();
        new WriterThread(list).start();
        new ReaderThread(list).start();
    }
}
