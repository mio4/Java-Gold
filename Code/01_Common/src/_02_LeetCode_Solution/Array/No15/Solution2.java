package _02_LeetCode_Solution.Array.No15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {

    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i < nums.length-2; i++){
            if(i == 0 || (i > 0 && nums[i-1] != nums[i])){
                int sum = -nums[i];
                int lo = i+1;
                int hi = nums.length-1;
                while(lo < hi){
                    if(nums[lo] + nums[hi] == sum){
                        res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                        while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++;
                        hi--;
                    }
                    else if(nums[lo] + nums[hi] < sum){
                        lo++;
                    }
                    else{
                        hi--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
//        int[] nums = {-1,0,1,2,-1,-4};
//        threeSum(nums);
        int[] nums2 = {0,0,0,0};
        threeSum(nums2);
    }

}
