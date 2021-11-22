package _02_LeetCode_Solution.Array.No739;

import java.util.Arrays;
import java.util.Stack;

/**
 * 将时间复杂度为O(n^2)，可以降低到一定程度
 */
public class Solution2 {
    public static int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i < len; i++){
            while(!st.empty() && T[i] > T[st.peek()]){
                int t = st.pop();
                res[t] = i - t;
            }
            st.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(T);
        System.out.println(Arrays.toString(res));
    }
}
