package _02_LeetCode_Solution.Array.No739;

import java.util.Arrays;

class Solution {
    public static int[] dailyTemperatures(int[] T) {
        if(T == null)
            return null;
        int len = T.length;
        int[] res = new int[len];

        for(int i=0; i < len; i++){
            int cnt = 0;
            for(int j=i+1; j < len; j++){
                cnt++;
                if(T[j] > T[i]){
                    res[i] = cnt;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(T);
        System.out.println(Arrays.toString(res));
    }
}
