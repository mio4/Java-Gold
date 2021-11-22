package _02_LeetCode_Solution.LinkedList.No160;

public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode a = headA,b = headB;
        while(a != b){
            a = (a != null) ? a.next : headB;
            b = (b != null) ? b.next : headA;
        }
        return a;
    }
}
