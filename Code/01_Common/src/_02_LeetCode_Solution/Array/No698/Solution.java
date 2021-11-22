package _02_LeetCode_Solution.Array.No698;

import java.util.ArrayList;
import java.util.List;

//TODO
class Solution {

    private static int[] visited;

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        //是否不能分
        if(nums.length < k){
            return false;
        }
        //是否是k的倍数
        int sum = 0;
        for(int i=0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum%k != 0){
            return false;
        }
        visited = new int[nums.length];
        sum = sum / k;
        //是否存在比num/k更大的数
        for(int i=0; i < nums.length; i++){
            if(nums[i] > sum){
                return false;
            }
        }
        //核心计算
        while (k > 0) {
            List<Integer> mark = new ArrayList<>();
            int cur_sum = 0;
            for (int i=0 ; i < nums.length; i++){
                if(visited[i] == 0) {
                    cur_sum += nums[i];
                    if (cur_sum > sum) {
                        cur_sum -= nums[i];
                    } else if (cur_sum == sum) {
                        visited[i] = 1;
                        k--;
                        break;
                    } else if (cur_sum < sum) {
                        visited[i] = 1;
                    }
                    mark.add(i);
                }
            }
        }

        for(int i=0; i < nums.length; i++){
            if(visited[i] == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        System.out.println(canPartitionKSubsets(nums,4));
    }
}
