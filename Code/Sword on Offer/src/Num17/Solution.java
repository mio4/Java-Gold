package Num17;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
	public ListNode Merge(ListNode list1,ListNode list2) {
		//假设存在空链表
		if(list1 == null)
			return list2;
		if(list2 == null)
			return list1;

		//对于一般情况
		ListNode pMergeHead = null;
		if(list1.val < list2.val){
			pMergeHead = list1;
			pMergeHead.next = Merge(list1.next,list2);
		}
		else{
			pMergeHead = list2;
			pMergeHead.next = Merge(list1,list2.next);
		}

		return pMergeHead;
	}
}
