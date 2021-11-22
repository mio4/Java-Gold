package Num31;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
	public static boolean IsPopOrder(int [] pushA,int [] popA) {
		Stack<Integer> s = new Stack<Integer>();
		int len_push = pushA.length;
		int len_pop = popA.length;
		int i = 0;
		for(int j=0; j < len_pop; j++){
			int x = popA[j];
			if(s.isEmpty() || s.peek()!=x){
				while(true){
					if(i >= len_push)
						return false;
					s.push(pushA[i]);
					i++;
					if(s.peek() == x) {
						s.pop();
						break;
					}
				}
			} else {
				s.pop();
			}
		}
		return true;
	}
	public void push(Stack<Integer> s, int x){
		s.push(x);
	}

	public static void main(String[] args){
		int a[] = {1,2,3,4,5};
		int b[] = {4,3,5,1,2};
		IsPopOrder(a,b);
	}
}
