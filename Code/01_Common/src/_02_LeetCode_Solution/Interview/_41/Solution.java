package _02_LeetCode_Solution.Interview._41;

public class Solution {
    public static int firstMissingPositive(int[] nums) {
        for(int i=0; i < nums.length; i++){
            while(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
        }

        for(int i=0; i < nums.length; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }

        return nums.length+1;
    }

    private static void swap(int[] nums,int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
//        int[] nums = {3,4,-1,1};
        int[] nums = {1,1};
        System.out.println(firstMissingPositive(nums));
    }
}
