package Basic.part14;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericDemo {

    public static void main(String[] args){
        ArrayList<String> al = new ArrayList<String>();
        al.add("s1");
        al.add("s2");
        al.add("s3");
        al.add("s4");
        //al.add(4);

        Iterator<String> iterator = al.iterator();
        while(iterator.hasNext()){






            String s = iterator.next();
            System.out.println(s + ":" + s.length());
        }
    }
}
