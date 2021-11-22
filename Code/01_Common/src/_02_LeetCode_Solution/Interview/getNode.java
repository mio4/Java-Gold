package _02_LeetCode_Solution.Interview;

import java.util.concurrent.locks.ReentrantLock;

public class getNode {

    /**
     *
     * @return 1-2-3-4-5
     */
    public static ListNode get1(){
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(3);
        ListNode t4 = new ListNode(4);
        ListNode t5 = new ListNode(5);

        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        t4.next = t5;

        return t1;
    }

    /**
     *
     * @return 1-2-3-2-1
     */
    public static ListNode get2(){
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(3);
        ListNode t4 = new ListNode(2);
        ListNode t5 = new ListNode(1);

        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        t4.next = t5;

        return t1;
    }

    /**
     *
     * @return 1-2-2-1
     */
    public static ListNode get3(){
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(2);
        ListNode t4 = new ListNode(1);

        t1.next = t2;
        t2.next = t3;
        t3.next = t4;

        return t1;
    }



}
