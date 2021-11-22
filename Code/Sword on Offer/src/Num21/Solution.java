package Num21;

import java.util.Stack;

public class Solution {
	public Stack<Integer> val_stack = new Stack<Integer>();
	public Stack<Integer> min_stack = new Stack<Integer>();
	public int min = Integer.MAX_VALUE;

	public void push(int node) {
		val_stack.push(node);
		if(node < min)
			min = node;
		min_stack.push(min);
	}

	public void pop() {
		if(!val_stack.isEmpty()) {
			val_stack.pop();
			min_stack.pop();
		}
	}

	public int top() {
		int min = min_stack.pop();
		min_stack.push(min);
		return min;
	}

	public int min() {
		return top();
	}
}
