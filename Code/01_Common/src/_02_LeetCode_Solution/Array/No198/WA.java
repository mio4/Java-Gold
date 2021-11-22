package _02_LeetCode_Solution.Array.No198;

/**
 * 递归会造成TLE
 */
public class WA {
    private static int max = 0;
    public static int rob(int[] nums) {
        resolve(0,0,nums);
        resolve(1,0,nums);
        return max;
    }

    private static void resolve(int index,int cur,int[] nums){
        if(nums == null || nums.length == 0 || index >= nums.length){
            return;
        }
        cur += nums[index];
        if(index+2 >= nums.length){
            if(cur > max){
                max = cur;
            }
        }
        resolve(index+2,cur,nums);
        resolve(index+3,cur,nums);
    }

    public static void main(String[] args){
        int[] a0 = {};
        System.out.println(rob(a0));
        int[] a1 = {1,2,3,1};
        System.out.println(rob(a1));
        int[] a2 = {2,7,9,3,1};
        System.out.println(rob(a2));
    }
}
