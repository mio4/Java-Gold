package _02_LeetCode_Solution.Array.No4;

import org.junit.Test;

public class testEven {

    @Test
    public void testEven(){ //判断一个数是偶数还是奇数
        int n1 = 1;
        int n2 = 2;
        int n3 = 3;
        int n4 = 4;
        System.out.println(n1 & (0x01));
        System.out.println(n2 & (0x01));
        System.out.println(n3 & (0x01));
        System.out.println(n4 & (0x01));
    }
}
