package _02_LeetCode_Solution.DP.No55;

/**
 * 贪心算法
 * 只需要看能够达到最后一个点已经最后一个点的右边就可以了
 * 对于每一个点：
 * （1）如果i > max_reach，说明不可能从前面的点到达这个点，可以break结束判断
 * （2）否则更新max_reach:代码能够前进到数组上最靠后位置的坐标
 */
class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int max_reach = 0;
        for(int i=0; i < len-1; i++){
            if(i > max_reach)
                break;
            max_reach = Math.max(max_reach,i+nums[i]);
        }
        return (max_reach >= len-1);
    }
}
