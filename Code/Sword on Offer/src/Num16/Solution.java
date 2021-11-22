package Num16;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
	public ListNode ReverseList(ListNode head) {
		ListNode reverseListHead = null; //针对空链表的情况进行初始化
		ListNode preNode = null; //头节点前面是null
		ListNode nowNode = head;
		while(nowNode != null){
			ListNode nextNode = nowNode.next;
			//处理链表只有一个节点的情况
			if(nextNode == null)
				reverseListHead = nowNode;
			//处理一般多节点的链表
			nowNode.next = preNode;
			preNode = nowNode;
			nowNode = nextNode;
		}
		return reverseListHead;
	}
}
