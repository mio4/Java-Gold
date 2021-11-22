package _02_LeetCode_Solution.Array.No215;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1. 使用util包下的PriorityQueue优先队列实现堆
 * 2. 根据Comparator接口的compare方法实现小顶堆
 *  （i）定义一个容量为k的小顶堆
 *  （ii）遍历数组，将数组中最大的K个数放入到小顶堆中
 *  （iii）最后小顶堆的根节点就是Kth的数
 * 涉及API：comparator<Integer>(){ compare(Integer o1, Integer o2)...}
 *         PriorityQueue.peek()返回头部节点 | offer(m)插入元素到堆中 | poll()删除头部节点
 */
class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2; //小顶堆
            }
        });
        for(Integer num : nums){
            if(queue.size() < k || num > queue.peek())
                queue.offer(num);
            if(queue.size() > k)
                queue.poll();
        }

        return queue.peek();
    }
}
