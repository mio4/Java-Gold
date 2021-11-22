package _02_LeetCode_Solution.Array.No665;

/**
 * 1. 需要考虑到三种可能
 * （1）对于第一个元素产生的decreasing
 * （2）对于其他一般元素的decreasing
 *      【1】需要考虑替换第i个元素或第i+1个元素两种情况
 *      【2】要保持整个序列的有序（最大值至少是第i-1个）
 * 2. 只需要遍历一遍数组即可判断出结果
 */
class Solution2 {
    public static boolean checkPossibility(int[] nums) {
        int i,count = 0;
        int len = nums.length;
        for(i=0; i < len-1 && count < 2; i++){
            if(nums[i] > nums[i+1]){
                if(i > 0){
                    if(nums[i-1] >= nums[i+1])
                        nums[i+1] = nums[i];
                    else
                        nums[i] = nums[i+1];
                }
                count++;
            }
        }
        return (count < 2);
    }
}
