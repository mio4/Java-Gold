package _02_LeetCode_Solution.Array.No75;

import java.util.Arrays;

class Solution {
    public static void sortColors(int[] nums) {
        int zero_cnt =0;
        int one_cnt = 0;
        int two_cnt = 0;
        for(int i=0; i < nums.length; i++){
            if(nums[i] == 0){
                zero_cnt++;
            }
            else if(nums[i] == 1){
                one_cnt++;
            }
            else if(nums[i] == 2){
                two_cnt++;
            }
        }
        for(int i=0; i < nums.length; i++){
            if(zero_cnt != 0){
                nums[i] = 0;
                zero_cnt--;
            }
            else if(one_cnt != 0){
                nums[i] = 1;
                one_cnt--;
            }
            else if(two_cnt != 0){
                nums[i] = 2;
                two_cnt--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2,0,2,1,1,0};
        sortColors(a);
        System.out.println(Arrays.toString(a));
    }
}
