package _02_LeetCode_Solution.LinkedList.No148;

/**
 * TODO 自己实现一遍归并排序下的快慢指针法
 * 1. 快慢指针法
 * 2.
 */
public class Solution2 {
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return merge(sortList(head), sortList(slow));
    }
    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode root = sortList(l1);
        System.out.println();
    }
}
