package _02_LeetCode_Solution.Array.No1;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
//        Arrays.sort(nums);
//        int[] res = new int[2];
//        int lo = 0;
//        int hi = nums.length-1;
//        while(lo < hi){
//            if(nums[lo] + nums[hi] == target){
//                res[0] = lo;
//                res[1] = hi;
//                break;
//            }
//            else if(nums[lo] + nums[hi] < target){
//                lo++;
//            }
//            else{
//                hi--;
//            }
//        }
//        return res;
        int[] res = new int[2];
        for(int i=0; i < nums.length; i++){
            for(int j=i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] arr = {3,2,4};
        twoSum(arr,6);
    }
}
