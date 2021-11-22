package _02_LeetCode_Solution.String.No43;

import java.util.LinkedList;

/**
 * 其实是一个模拟乘法的过程
 * 边界条件：
 * （1）两个数中有一个数是0的情况
 * 计算过程可以简化
 */
class Solution2 {
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        LinkedList<Integer> list = new LinkedList<Integer>();
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length(),len2 = num2.length();
        //1.计算num2最后一位数和num1相乘的结果
        int offset = -1;
        for(int i2 = len2-1; i2 >= 0; i2--){
            int flow = 0;
            offset++;
            LinkedList<Integer> tmp = new LinkedList<Integer>();
            for(int i1 = len1-1; i1 >= 0; i1--){
                int mul = (num1.charAt(i1) - '0') * (num2.charAt(i2) - '0') + flow;
                int cur = mul%10;
                if(i2 == len2-1)
                    list.addFirst(cur);
                else
                    tmp.addFirst(cur);
                flow = mul/10;
            }
            if(i2 == len2-1)
                list.addFirst(flow);
            else
                tmp.addFirst(flow);
            if(tmp.size() != 0){ //2.计算剩下的数，并且加法
                list.addFirst(0);
                flow = 0;
                for(int k=list.size()-1-offset; k >=0; k--){
                    int cur = (list.get(k) + tmp.get(k) + flow)%10;
                    flow = (list.get(k) + tmp.get(k) + flow)/10;
                    list.set(k,cur);
                }
            }
        }

        if(list.get(0) != 0)
            sb.append(list.get(0));
        for(int i=1; i < list.size(); i++){
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String s1 = "123";
        String s2 = "456";
        System.out.println(multiply(s1,s2));
    }
}
