package _02_LeetCode_Solution.LinkedList.No160;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

public class Solution {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode res = null;
        ListNode pa = headA;
        while(pa != null){
            if(isAfter(headB,pa)){
                res = pa;
                break;
            }
            pa = pa.next;
        }
        return res;
    }

    public static boolean isAfter(ListNode p1,ListNode p2){
        while(p1 != null){
            if(p1 == p2)
                return true;
            p1 = p1.next;
        }
        return false;
    }
}