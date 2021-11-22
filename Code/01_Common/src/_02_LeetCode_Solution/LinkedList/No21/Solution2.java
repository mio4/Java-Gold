package _02_LeetCode_Solution.LinkedList.No21;

/**
 * （1）假设一个没有用的头结点，这样就不用考虑头结点为空的情况
 * （2）当存在剩余链表没有合并的时候，直接使用“指针”的特性，将cur.next指向剩余的部分
 * （3）相对于方法一，只需要维护一个指针
 *
 */
class Solution2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fake = new ListNode(-1);
        ListNode cur = fake;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }
            else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null) ? l1 : l2; //wonderful code!
        return fake.next;
    }
}
