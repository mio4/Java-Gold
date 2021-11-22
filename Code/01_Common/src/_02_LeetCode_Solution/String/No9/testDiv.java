package _02_LeetCode_Solution.String.No9;

import org.junit.Test;

public class testDiv {
    @Test
    public void testDiv(){
        int x = 0;
        int times = 1;
        while(x / times > 1) times*=10;
    }

    @Test
    public void testDiv2(){
        int x = 0;
        int y = 0/10;
    }
}
