package _02_LeetCode_Solution.String.No43;

import java.util.LinkedList;

/**
 * 比第一个程序的逻辑更加清晰
 * beats 6.7%
 * TODO 使用傅里叶变换 | FTT方法做快速乘
 */
class Solution3 {
    public static String multiply(String num1, String num2) {
        int len1 = num1.length(),len2 = num2.length();
        if("0".equals(num1) || "0".equals(num2))
            return "0";
        StringBuilder res = new StringBuilder();
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        //0.初始化
        for(int i=0;i < len1+len2; i++)
            tmp.add(0);
        //1.计算中间结果
        for(int i=len1-1; i >= 0; i--){
            for(int j=len2-1; j >= 0; j--){
                int middle = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                tmp.set(i+j+1,tmp.get(i+j+1)+middle);
            }
        }
        //2.进位计算
        int flow = 0;
        for(int i=len1+len2-1; i >= 0; i--){
            int cur = tmp.get(i) + flow;
            tmp.set(i,cur%10);
            flow = cur/10;
        }
        //3.最终结果
        if(tmp.get(0) != 0)
            res.append(tmp.get(0));
        for(int i=1; i < len1+len2; i++)
            res.append(tmp.get(i));
        return res.toString();
    }

    public static void main(String[] args){
        String s1 = "123";
        String s2 = "456";
        System.out.println(multiply(s1,s2));
    }
}
