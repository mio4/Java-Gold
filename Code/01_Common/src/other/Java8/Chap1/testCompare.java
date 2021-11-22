package other.Java8.Chap1;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class testCompare {

    public static void main(String[] args){
        Integer[] arr = {5,6,3,4,10};
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testThread(){
        Thread t = new Thread(()->System.out.println("me"));
        t.start();
    }
}
