package _02_LeetCode_Solution.LinkedList.No2;

/**
 * 思路没有问题，但是只能适合于短链表的情况
 * 这种方法不能AC，当两个链表的长度过长之后，num3的结果甚至会超过long类型限制，溢出出错
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
    }
}
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1 = 0, num2 = 0, num3 = 0;
        int count = 0;
        while(l1 != null){
            num1 += l1.val * Math.pow(10,count);
            count++;
            l1 = l1.next;
        }
        count = 0;
        while(l2 != null){
            num2 += l2.val * Math.pow(10,count);
            count++;
            l2 = l2.next;
        }
        num3 = num1 + num2;
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        if(num3 == 0)
            return new ListNode(0);
        while(num3 != 0){
            temp.next = new ListNode( (int) (num3%10));
            temp = temp.next;
            num3 /= 10;
        }
        return head.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode temp = l1;
        for(int i=0; i < 9; i++){
            temp.next = new ListNode(9);
            temp = temp.next;
        }
        ListNode l2 = new ListNode(9);
        ListNode answer = addTwoNumbers(l2,l1);
    }
}
