package _02_LeetCode_Solution.Array.No448;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
class Solution {

    /**
     * Brute Force TLE
     * @param nums
     * @return
     */
//    public static List<Integer> findDisappearedNumbers(int[] nums) {
//        List<Integer> res = new ArrayList<>();
//
//        for(int i=1; i <= nums.length; i++){
//            int j = 0;
//            for(; j < nums.length; j++){
//                if(i == nums[j]){
//                    break;
//                }
//            }
//            if(j == nums.length){
//                res.add(i);
//            }
//        }
//
//        return res;
//    }

    /**
     * 1. 数字出现1次 | 2次
     * 2. 数字的范围是1~n => 数字的范围是有限的，这里暗示适用map求解
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> res = new ArrayList<>();
        int[] map = new int[nums.length+1];

        for(int i=0; i < nums.length;i++){
            map[nums[i]]++;
        }

        for(int i=1; i < nums.length+1;i++){
           if(map[i] == 0){
               res.add(i);
           }
        }

        return res;
    }













    public static void main(String[] args) {
        int[] a = {4,3,2,7,8,2,3,1};
        findDisappearedNumbers(a);
    }
}
