package _02_LeetCode_Solution.Array.No1;

import java.util.HashMap;

public class BestSolution {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i=0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        for(int i=0; i < nums.length; i++){
            int t = target - nums[i];
            if(map.containsKey(t) && map.get(t) != i){
                res[0] = i;
                res[1] = map.get(t);
                break;
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[] arr = {3,2,4};
        twoSum(arr,6);
    }
}
