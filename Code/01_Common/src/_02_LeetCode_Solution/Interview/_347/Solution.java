package _02_LeetCode_Solution.Interview._347;

import java.util.*;

class Item{
    int val = 0;
    int cnt = 0;
}
public class Solution {
    private static Comparator<Item> comparator = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return o2.cnt - o1.cnt;
        }
    };

    private static PriorityQueue<Item> queue = new PriorityQueue<>(comparator);
    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }

        Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Integer> entry = iterator.next();
            Item item = new Item();
            item.val = entry.getKey();
            item.cnt = entry.getValue();
            queue.add(item);
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0; i < k; i++){
            res.add(queue.poll().val);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(topKFrequent(nums,2));
    }


}
