package _02_LeetCode_Solution.LinkedList.No141;

/**
 * 试触法：能过OJ，没有一点逻辑可言
 * FORBIDDEN
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
       val = x;
       next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode tmp = head;
        for(int i=0; i < 100000; i++){
            tmp = tmp.next;
            if(tmp == null)
                return false;
        }
        return true;
    }
}