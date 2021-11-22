package _02_LeetCode_Solution.LinkedList.No82;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用HashMap，遍历两遍，第一遍做标记，第二遍删除节点
 * 理解判断：
 * （1）重复出现的节点是否一定是连续的
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        ListNode temp = head;
        ListNode dummy = new ListNode(-1);
        //1.第一遍，只做标记
        while(temp!=null){
            if(!map.containsKey(temp.val))
                map.put(temp.val,0);
            else
                map.put(temp.val,1);
            temp = temp.next;
        }
        //2.第二遍，构造新的节点
        temp = dummy;
        ListNode myHead = head;
        while(myHead != null){
            if(map.get(myHead.val) == 0){ //没有重复元素
                temp.next = new ListNode(myHead.val);
                temp = temp.next;
                temp.next = null;
            }
            else if(map.get(myHead.val) == 1){ //有重复元素

            }
            myHead = myHead.next;
        }
        return dummy.next;
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
        deleteDuplicates(l1);
    }
}