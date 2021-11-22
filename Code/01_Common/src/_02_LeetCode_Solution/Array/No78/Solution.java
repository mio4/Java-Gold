package _02_LeetCode_Solution.Array.No78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for(int i=0; i < nums.length; i++){
            int size = res.size();
            for(int j=0; j < size; j++){
                res.add(new ArrayList<Integer>());
                res.get(res.size()-1).addAll(res.get(j));
                res.get(res.size()-1).add(nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
}