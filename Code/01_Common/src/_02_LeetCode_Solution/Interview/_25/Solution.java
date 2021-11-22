package _02_LeetCode_Solution.Interview._25;

import _02_LeetCode_Solution.Interview.getNode;
import _02_LeetCode_Solution.Interview.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static ListNode reverseKGroup(ListNode head, int k) {
        List<Integer> t_list = new ArrayList<>();
        while(head != null){
            t_list.add(head.val);
            head = head.next;
        }

        List<Integer> t_list2 = new ArrayList<>();
        int initial = k-1;
        int i=0;
        while(initial < t_list.size()){
            for(i=initial;i > initial-k; i--){
                t_list2.add(t_list.get(i));
            }
            initial += k;
        }
        for(int j=initial-k+1; j < t_list.size();j++){
            t_list2.add(t_list.get(j));
        }

        if(t_list2.size() == 0){
            return null;
        }
        ListNode res = new ListNode(t_list2.get(0));
        ListNode cur = res;
        for(int j=1; j < t_list2.size(); j++){
            ListNode t = new ListNode(t_list2.get(j));
            cur.next = t;
            cur = t;
        }
        cur.next = null;
        return res;
    }

    public static void main(String[] args) {
        reverseKGroup(getNode.get1(),2);
    }
}
