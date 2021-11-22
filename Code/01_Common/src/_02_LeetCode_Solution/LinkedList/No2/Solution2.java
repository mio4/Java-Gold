package _02_LeetCode_Solution.LinkedList.No2;

/**
 * 在访问任何变量的属性之前，需要考虑这个变量是否是null
 * 链表问题设置一个dummy头指针非常好用
 * 何为链表问题的边界情况：
 * （1）到链表末尾的时候
 * （2）其中一条链表为空的时候
 * （3）两条链表都是空链表的时候
 */
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int val = (l1 != null ? l1.val : 0);
            val += (l2 != null ? l2.val : 0);
            val += carry;
            temp.next = new ListNode(val%10);
            temp = temp.next;
            carry = val/10;
            l1 = (l1 != null ? l1.next : null);
            l2 = (l2 != null ? l2.next : null);
        }
        return dummy.next;
    }
}
