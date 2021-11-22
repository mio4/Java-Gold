package _02_LeetCode_Solution.Interview._23;

import _02_LeetCode_Solution.Interview.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution3 {
    private static Comparator<ListNode> comparator = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    };

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(comparator);
        for(ListNode node : lists){
            while(node != null){
                queue.add(node);
                node = node.next;
            }
        }

        if(queue.size() < 0){
            return null;
        }

        ListNode head = queue.poll();
        ListNode cur = head;
        while(!queue.isEmpty()){
            ListNode t = queue.poll();
            cur.next = t;
            cur = t;
        }
        cur.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode t1 = new ListNode(-2);
        ListNode t2 = new ListNode(-1);
        ListNode t3 = new ListNode(-1);
        ListNode t4 = new ListNode(-1);
        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        ListNode[] nodes = new ListNode[2];
        nodes[0] = t1;
        mergeKLists(nodes);
    }
}
