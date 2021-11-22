package _02_LeetCode_Solution.LinkedList.No142;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode slow = head;
        ListNode quick = head;
        boolean isCycle = false;
        while(quick.next != null && quick.next.next != null){
            slow = slow.next;
            quick = quick.next.next;
            if(slow == quick){
                isCycle = true;
                break;
            }
        }
        if(!isCycle){
            return null;
        }
        else{
            slow = head;
            while(slow != quick){
                slow = slow.next;
                quick = quick.next;
            }
            return slow;
        }
    }
}
