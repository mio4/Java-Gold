package _02_LeetCode_Solution.Interview._20;

import java.util.Stack;

class Solution {
    public static boolean isValid(String s) {
        char[] cs = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i < s.length(); i++){
            char c = cs[i];
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                if((c == ')' && stack.peek() == '(')
                        || (c == ']' && stack.peek() == '[')
                        || (c == '}' && stack.peek() == '{')){
                    stack.pop();
                }
                else{
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }
}
