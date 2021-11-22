package _02_LeetCode_Solution.Array.No198;

/**
 * WA 思路不对
 */
public class HouseRobber {
    public static int rob(int[] nums) {
        int max_sum = 0;
        int cur_sum = 0;
        for(int i=0; i < nums.length; i+=2){
            cur_sum += nums[i];
        }
        max_sum = cur_sum;
        cur_sum = 0;
        for(int i=1; i < nums.length; i+=2){
            cur_sum += nums[i];
        }
        if(cur_sum > max_sum){
            max_sum = cur_sum;
        }
        return max_sum;
    }

    public static void main(String[] args){
        int[] a1 = {1,2,3,1};
        int[] a2 = {2,7,9,3,1};
        System.out.println(rob(a1));
        System.out.println(rob(a2));
    }
}
