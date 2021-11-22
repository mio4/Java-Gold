package _02_LeetCode_Solution.Interview._234;

import _02_LeetCode_Solution.Interview.getNode;
import _02_LeetCode_Solution.Interview.ListNode;

class Solution {
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        if(head.next.next == null) return head.val == head.next.val;

        ListNode slow = head,fast = head;
        ListNode pre = null,next = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;

            slow.next = pre;
            pre = slow;
            slow = next;
            next = slow.next;
        }

        ListNode l1 = pre;
        ListNode l2 = fast == null ? slow : next;

        while(l2 != null){
            if(l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode node = getNode.get3();
        System.out.println(isPalindrome(node));
    }
}
