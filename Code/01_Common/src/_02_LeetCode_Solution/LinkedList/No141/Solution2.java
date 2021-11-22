package _02_LeetCode_Solution.LinkedList.No141;

/**
 * 快慢指针：如果有环，那么两个指针一定会相遇
 * 还是要注意空指针的问题
 */
public class Solution2 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}
