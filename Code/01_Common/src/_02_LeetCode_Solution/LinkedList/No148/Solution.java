package _02_LeetCode_Solution.LinkedList.No148;

/**
 * 这是一道很经典的排序问题
 * 平时只对数组进行过排序，现在对链表排序有·意思
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    public static void MergeSort(ListNode head,int low, int high){
        if(low < high){
            int mid = (low+high)/2;
            MergeSort(head,low,mid);
            MergeSort(head,mid+1,high);
            Merge(head,low,mid,high);
        }
    }

    public static void Merge(ListNode head,int low,int mid,int high){

    }

    public static ListNode sortList(ListNode head) {

        return null;
    }

    public static void main(String[] args){

    }
}
