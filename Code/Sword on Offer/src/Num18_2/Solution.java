package Num18_2;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
	public static ListNode deleteDuplication(ListNode pHead)
	{
		if(pHead == null || pHead.next == null) //空节点以及单个节点特殊情况
			return pHead;

		ListNode preNode = null; //记录当前节点的前驱节点
		ListNode nowNode = pHead; //当前节点
		ListNode postNode = pHead; //记录比当前节点数值大的节点
		while(nowNode != null && nowNode.next != null){
			if(nowNode.val == nowNode.next.val){
				while(postNode.val <= nowNode.val){
					postNode = postNode.next;
					if(postNode == null)
						break;
				}
				if(preNode == null) {
					pHead = postNode;
				} else {
					preNode.next = postNode;
				}
				nowNode = postNode;
			} else{
				preNode = nowNode;
				nowNode = nowNode.next;
			}
		}
		return pHead;
	}

	public static void main(String[] args){
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(4);
		ListNode l6 = new ListNode(4);
		ListNode l7 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		deleteDuplication(l1);
		System.out.println(l1);
	}
}
