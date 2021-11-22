package _02_LeetCode_Solution.LinkedList.No206;

/**
 * Classic-翻转链表
 * 1. 遍历时使用三个指针
 * 2. 对于head之前的节点，改变next指向prev【之前的节点】
 * 3. 时间复杂度O(n)
 */
class Solution2 {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null){
            ListNode temp = head;
            head = head.next;
            temp.next = prev;
            prev = temp;
        }
        return prev;
    }

}
