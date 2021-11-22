package _02_LeetCode_Solution.Array.No75;

import java.util.Arrays;

public class Solution2 {
    public static void sortColors(int[] nums) {
        int[] cnt = new int[3];
        for(int i=0;i < nums.length; i++){
            cnt[nums[i]]++;
        }
        for(int i=0,cur=0; i < 3; i++){
            for(int j=0; j < cnt[i]; j++){
                nums[cur++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2,0,2,1,1,0};
        sortColors(a);
        System.out.println(Arrays.toString(a));
    }
}
