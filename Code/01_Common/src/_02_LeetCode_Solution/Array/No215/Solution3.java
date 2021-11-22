package _02_LeetCode_Solution.Array.No215;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 小顶堆的自我实现
 */
class Solution3 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k,new Comparator<Integer>(){
           @Override
           public int compare(Integer o1,Integer o2){
               return (o1 - o2);
           }
        });
        for(int num : nums){
            if(queue.size() < k)
                queue.offer(num);
            else{
                if(num > queue.peek()){
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        return queue.peek();
    }
}
