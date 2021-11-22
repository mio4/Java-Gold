package _02_LeetCode_Solution.LinkedList.No21;

/**
 * 21. Merge Two Sorted Lists
 * 在解题的过程发现对于双链表指针的操作不是很熟悉，并且对于边界输入的情况考虑不全面，最后AC的代码也不是很简洁
 * 需要重构
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
class Solution {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null,temp = null;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                if(head == null) {
                    head = l1;
                    temp = head;
                    l1 = l1.next;
                }
                else {
                    temp.next = l1;
                    temp = temp.next;
                    l1 = l1.next;
                }
            }
            else {
                if(head == null) {
                    head = l2;
                    temp = head;
                    l2 = l2.next;
                }
                else {
                    temp.next = l2;
                    temp = temp.next;
                    l2 = l2.next;
                }
            }
        }

        while(l1 != null){
            if(head == null) {
                head = l1;
                temp = head;
                l1 = l1.next;
            }
            else {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }
        }

        while(l2 != null){
            if(head == null) {
                head = l2;
                temp = head;
                l2 = l2.next;
            }
            else {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }

        return head;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;
        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;
        l23.next = null;
        mergeTwoLists(l1,l21);

        ListNode t1 = null;
        ListNode t2 = new ListNode(0);
        mergeTwoLists(t1,t2);
    }
}
