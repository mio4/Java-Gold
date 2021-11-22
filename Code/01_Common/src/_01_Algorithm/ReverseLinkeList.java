package _01_Algorithm;

/**
 * Classic LeetCode
 * 反转单链表
 * 精髓在于Java中引用：
 * (1)ListNode head = new ListNode(1)，head的引用指向了一个结构体，内容为1，
 * (2)head = head.next,head指向了原有head的下一个节点，当前节点如果没有被记录，就遗失了[所以需要ListNode tmp记录current head]
 * (3)确定while循环的结束条件，并且防止NullPointerException
 */

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}
public class ReverseLinkeList {
    //非递归写法
    public static ListNode reverseList(ListNode head) {
        //处理边界条件
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        while(head != null){
            ListNode temp = head;
            head = head.next;
            temp.next = prev;
            prev = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        l2.next = null;

        reverseList(l1);
    }
}
