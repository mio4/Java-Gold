package _02_LeetCode_Solution.Array.No152;

public class Solution2 {
    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int[] dp_min = new int[nums.length];
        int[] dp_max = new int[nums.length];
        dp_min[0] = nums[0];
        dp_max[0] = nums[0];
        for(int i=1; i < nums.length; i++){
            dp_min[i] = Math.min(Math.min(dp_min[i-1]*nums[i],dp_max[i-1]*nums[i]),nums[i]);
            dp_max[i] = Math.max(Math.max(dp_min[i-1]*nums[i],dp_max[i-1]*nums[i]),nums[i]);
            max = Math.max(dp_max[i],max);
        }
        return max;
    }

    public static void main(String[] args){
        int[] a = {2,3,-2,4};
        int[] b = {-2,0,-1};
        int[] c = {2,3,2,4};
        System.out.println(maxProduct(a));
        System.out.println(maxProduct(b));
        System.out.println(maxProduct(c));
    }
}
