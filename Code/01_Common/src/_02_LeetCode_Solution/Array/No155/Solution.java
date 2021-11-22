package _02_LeetCode_Solution.Array.No155;

import java.util.Stack;

/**
 * elegant solution !
 */
public class Solution {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public Solution() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void push(int x) {
        s1.push(x);
        if(s2.empty() || s2.peek() >= x)
            s2.push(x);
    }

    public void pop() {
        int top = s1.pop();
        if(top == getMin())
            s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }
}
