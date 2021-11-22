package _02_LeetCode_Solution.Array.No189;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * 使用双向队列
 * 每次从尾部取出，插入到头部
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int i;
        int len;
        Deque<Integer> queue = new ArrayDeque<Integer>();
        len = nums.length;
        k %= len;
        for(i = 0; i < len; i++){
            queue.addLast(nums[i]);
        }
        for(i = 0; i < k; i++){
            int last_one = queue.pollLast();
            queue.addFirst(last_one);
        }

        Iterator<Integer> iterator = queue.iterator();
        i = 0;
        while(iterator.hasNext()){
            nums[i] = iterator.next();
            i++;
        }
    }
}
