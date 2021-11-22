package _02_LeetCode_Solution.Heap.No347;


import java.util.*;

/**
 * 统计出现次数最多的K个元素
 * （1）使用HashMap存放键值对
 * （2）使用List.sort()根据Map.Entry
 */
class Solution {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for(int i=list.size()-1; i >= list.size()-k; i--){
            result.add(list.get(i).getKey());
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,3};
        topKFrequent(nums,2);
    }
}