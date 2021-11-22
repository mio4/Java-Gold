package _02_LeetCode_Solution.Array.No621;

import java.util.Arrays;

/**
 * 参考贪心算法
 */
public class Solution2 {
    public static int leastInterval(char[] tasks, int n) {

        int[] c = new int[26];
        for(char t : tasks){
            c[t - 'A']++;
        }
        Arrays.sort(c);
        int i = 25;
        while(i >= 0 && c[i] == c[25]) i--;

        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }

    public static void main(String[] args){
//        char[] c = {'A','A','A','A','B','B','B','E','E','F','F','G','G'};
        char[] c = {'A','A','A','B','B','B'};
        leastInterval(c,3);
    }
}
