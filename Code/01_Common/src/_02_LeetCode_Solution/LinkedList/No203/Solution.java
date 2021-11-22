package _02_LeetCode_Solution.LinkedList.No203;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}

class Solution {
    public static ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        ListNode support = new ListNode(-1);
        ListNode before = support,cur = head;
        support.next = head;
        while(cur != null){
            if(cur.val == val){
                before.next = cur.next;
                cur = cur.next;
            }
            else{
                before = cur;
                cur = cur.next;
            }
        }
        return support.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        ListNode res = removeElements(l1,6);
        System.out.println();
    }

}
