package Num15;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
	public ListNode FindKthToTail(ListNode head,int k) {
		ListNode p1 = head;
		if(p1 == null || k <= 0)
			return null;
		for(int i=0; i < k-1; i++){
			if(p1.next == null)
				return null;
			p1 = p1.next;
		}
		ListNode p2 = head;

		while(p1.next != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
}
