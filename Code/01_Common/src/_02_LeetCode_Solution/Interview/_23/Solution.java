package _02_LeetCode_Solution.Interview._23;

import _02_LeetCode_Solution.Interview.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> t_list = new ArrayList<>();
        for(ListNode node : lists){
            while(node != null){
                t_list.add(node.val);
                node = node.next;
            }
        }

        int[] t_num = new int[t_list.size()];
        for(int i=0; i < t_list.size(); i++){
            t_num[i] = t_list.get(i);
        }
        Arrays.sort(t_num);

        if(t_list.size() <= 0){
            return null;
        }
        ListNode head = new ListNode(t_num[0]);
        ListNode cur = head;
        for(int i=1;i < t_list.size(); i++){
            ListNode t = new ListNode(t_num[i]);
            cur.next = t;
            cur = t;
        }

        return head;
    }
}