package Interview2020.SenseTime._1;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(" ");

        Stack<Integer> stack = new Stack<>();
        for(String t : ss){
            if(isCal(t)){
                int a2 = stack.pop();
                int a1 = stack.pop();
                if(t.equals("+")) stack.push(a1+a2);
                else if(t.equals("-")) stack.push(a1-a2);
                else if(t.equals("*")) stack.push(a1*a2);
                else if(t.equals("/")) stack.push(a1/a2);
            }
            else{
                stack.push(Integer.valueOf(t));
            }
        }

        System.out.println(stack.peek());
    }

    private static boolean isCal(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
            return true;
        return false;
    }
}
