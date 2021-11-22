package _02_LeetCode_Solution.LinkedList.No82;

/**
 * 修改自己的第一种方案
 * （1）链表问题考虑是否是空链表还是只有一个节点的情况
 * （2）TODO 手写实现这种题型
 */
class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(pre.next != null){
            ListNode cur = pre.next;
            while(cur.next != null && cur.next.val == cur.val) //跳过重复的元素
                cur = cur.next;
            if(cur != pre.next) //链接到重复元素开始的节点
                pre.next = cur.next;
            else
                pre = pre.next; //pre指向cur当前节点
        }
        return dummy.next;
    }
}
