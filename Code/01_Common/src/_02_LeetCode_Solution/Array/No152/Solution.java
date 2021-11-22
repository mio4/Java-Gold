package _02_LeetCode_Solution.Array.No152;

public class Solution {
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i < nums.length; i++){
            int cur = nums[i];
            for(int j=i+1; j < nums.length; j++){
                if(cur > max){
                    max = cur;
                }
                cur *= nums[j];
            }
            if(cur > max){
                max = cur;
            }
        }

        return max;
    }

    public static void main(String[] args){
        int[] a = {2,3,-2,4};
        int[] c = {2,3,2,4};
        int[] b = {-2,0,-1};
        System.out.println(maxProduct(a));
        System.out.println(maxProduct(b));
        System.out.println(maxProduct(c));
    }
}
