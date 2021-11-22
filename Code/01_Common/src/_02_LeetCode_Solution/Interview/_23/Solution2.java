package _02_LeetCode_Solution.Interview._23;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {

    private static Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            //return o1 - o2;
            return o2 - o1;
        }
    };

    public static void main(String[] args) {
        //首先是测试优先队列
        PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);
        queue.add(1);
        queue.add(5);
        queue.add(3);
        queue.add(2);
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
