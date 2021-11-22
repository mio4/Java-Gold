package _02_LeetCode_Solution.Array.No621;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 做不出来
 * 可能需要使用优先队列
 */
class Solution {
    private ArrayList<Character> window = new ArrayList<>();
    public static int leastInterval(char[] tasks, int n) {
        int result = 0;
        int[] marks = new int[tasks.length];
        Arrays.sort(tasks);
        for(int i=0; i < tasks.length; i++){
            if(marks[i] == 0){
                result++;
                marks[i] = 1;
                for(int j=0; j < n; j++){

                }
            }
        }
        return result;
    }


    public static void main(String[] args){
        char[] c = {'A','A','A','B','B','B'};
        char[] t = {'B','A','B','A','B','A'};

//        Arrays.sort(t);
//        System.out.println(Arrays.toString(t));
    }
}
