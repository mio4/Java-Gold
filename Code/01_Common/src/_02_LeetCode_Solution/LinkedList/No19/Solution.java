package _02_LeetCode_Solution.LinkedList.No19;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p1 = dummyHead,p2 = dummyHead;
        dummyHead.next = head;
        //1.第一个指针先走n+1步
        for(int i=0; i < n+1; i++){
            p2 = p2.next;
        }
        //2.第一个指针和第二个指针同时走，直到第二个指针结束
        while(p2 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        //3.删除第二个指针的下一个节点
        p1.next = p1.next.next;
        return dummyHead.next;
    }
}
