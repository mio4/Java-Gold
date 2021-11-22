package _02_LeetCode_Solution.Array.No15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * WA try another way
 */
public class Soluton {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 2){
            return list;
        }
        Arrays.sort(nums);
        for(int a=0; a < nums.length; a++){
            for(int b=a+1; b < nums.length; b++){
                for(int c=b+1; c < nums.length; c++){
                    if(nums[a]+nums[b]+nums[c] == 0){
                        ArrayList<Integer> res = new ArrayList<Integer>();
                        res.add(nums[a]);
                        res.add(nums[b]);
                        res.add(nums[c]);
                        list.add(res);
                    }
                }
            }
        }

        boolean flag = true;
        while(flag) {
            flag = false;
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (removeDuplicate(list.get(j - 1), list.get(j))) {
                        list.remove(j);
                        flag = true;
                    }
                }
            }
        }

        return list;
    }

    private static boolean removeDuplicate(List<Integer> list1,List<Integer> list2){
        int a1 = list1.get(0);
        int a2 = list1.get(1);
        int a3 = list1.get(2);
        int b1 = list2.get(0);
        int b2 = list2.get(1);
        int b3 = list2.get(2);
        if(a1 == b1 && a2 == b2 && a3 == b3){
            return true;
        }
        return false;
    }

//    private static int[] removeDuplicate(int[] origin){
//        List<Integer> list = new ArrayList<Integer>();
//        for(int i=0; i < origin.length; i++){
//            if(!list.contains(origin[i])){
//                list.add(origin[i]);
//            }
//        }
//        int[] new_arr = new int[list.size()];
//        for(int i=0; i < list.size(); i++){
//            new_arr[i] = list.get(i);
//        }
//        return new_arr;
//    }

    public static void main(String[] args){
//        int[] nums = {-1,0,1,2,-1,-4};
//        threeSum(nums);
        int[] nums2 = {0,0,0,0};
        threeSum(nums2);
    }

}
