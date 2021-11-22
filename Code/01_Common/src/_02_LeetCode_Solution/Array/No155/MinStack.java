package _02_LeetCode_Solution.Array.No155;

import java.util.ArrayList;

/**
 * 解法不够优雅
 */
public class MinStack {
    private int min;
    private ArrayList stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList();
    }

    public void push(int x) {
        stack.add(x);
    }

    public void pop() {
        stack.remove(stack.size()-1);
    }

    public int top() {
        return (int)stack.get(stack.size()-1);
    }

    public int getMin() {
        min = Integer.MAX_VALUE;
        for(int i=0; i < stack.size(); i++){
            if((int)stack.get(i) < min){
                min = (int) stack.get(i);
            }
        }
        return min;
    }

    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
