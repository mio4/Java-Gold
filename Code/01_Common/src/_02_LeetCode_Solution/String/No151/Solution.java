package _02_LeetCode_Solution.String.No151;

/**
 * 151. Reverse Words in a String
 * 正则表达式： \\s表示空格，\\s+表示1~n个空格, \\s+," "表示替换为一个空格
 */
public class Solution {
    public static String reverseWords(String s) {
        String[] strs = s.trim().split("\\s+");
        StringBuilder res = new StringBuilder();
        for(int i=strs.length-1; i >=0; i--){
            if(i != 0)
                res.append(strs[i] + " ");
            else
                res.append(strs[i]);
        }
        return res.toString();
    }

    public static void main(String[] args){
        System.out.println(reverseWords(" the sky   is blue  "));
    }
}
