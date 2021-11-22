package _02_LeetCode_Solution.Permutation.No567;

import org.junit.Test;

import java.util.Arrays;

public class testArrays {


    @Test
    public void test1(){
        int[] a = new int[10];
        a[0] = 1;
        a[0]++;
        System.out.println(a[0]);
    }

    public static void main(String[] args){
        int[] a1 = new int[10];
        int[] a2 = new int[10];
        a1[1] = 5;
        a1[5] = 10;
        a2[1] = 5;
        a2[5] = 0;
        System.out.println(Arrays.equals(a1,a2));
    }
}
