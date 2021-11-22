package Num7;

import java.util.Stack;

public class Solution {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		if(stack2.size() != 0){
			return stack2.pop();
		}
		while(stack1.size() != 0){
			stack2.push(stack1.pop());
		}
		int res = stack2.pop();
		return res;
	}

	public static void main(String[] args){
		Solution s = new Solution();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.pop());
		System.out.println(s.pop());
		s.push(4);
		System.out.println(s.pop());
		s.push(5);
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}
