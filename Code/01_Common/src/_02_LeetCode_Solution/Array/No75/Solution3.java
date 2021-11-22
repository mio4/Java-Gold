package _02_LeetCode_Solution.Array.No75;

import java.util.Arrays;

/**
 * TODO NOT FINISHED
 */
class Solution3 {
    public static void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        for(int i=0; i < blue; i++){
            if(nums[i] == 2){
                swap(nums,i,blue);
                blue--;
            }
            else if(nums[i] == 0){
                swap(nums,i,red);
                red++;
            }
        }
    }

    private static void swap(int[] nums,int a, int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void main(String[] args) {
        int[] a = {2,0,2,1,1,0};
        sortColors(a);
        System.out.println(Arrays.toString(a));
    }
}
