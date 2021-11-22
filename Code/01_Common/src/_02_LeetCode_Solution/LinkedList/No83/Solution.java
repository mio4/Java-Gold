package _02_LeetCode_Solution.LinkedList.No83;

/**
 * 83. Remove Duplicates from Sorted List
 * 问题：对于指针玩的不够好
 * 需要针对链表问题多加练习
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode pre = head,next;
        while(cur != null){
            next = cur.next;
            while(cur.next != null && cur.val == next.val){ //首先找到不重复的元素
                cur = cur.next;
                next = cur.next;
            }
            pre.next = next; //改变pre指针指向第一个不重复的元素
            cur = cur.next;
            pre = cur;
        }
        return head;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        deleteDuplicates(l1);
    }
}
