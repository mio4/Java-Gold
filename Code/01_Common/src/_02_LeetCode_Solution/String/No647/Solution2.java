package _02_LeetCode_Solution.String.No647;

/**
 * 1. 回文字符串的分类
 *  （1）奇数形式：ABA
 *  （2）偶数形式：ABBA
 *
 * 2.使用扩散的思想：
 *      遍历每一个字符，找到以它为中心的所有的回文字符串，就是所有的情况
 */
public class Solution2 {

    private static int res = 0;
    public static int countSubstrings(String s) {
        if(s == null || s.length() == 0){
            return res;
        }
        for(int i=0; i < s.length(); i++){
            helper(s,i,i);
            helper(s,i,i+1);
        }

        return res;
    }

    /**
     * 1. 保证字符串不越界
     * 2. 一旦不满足s.charAt(i) == s.charAt(j)，就和『以i为中心的字符串』这个前提假设矛盾，直接break，不能继续判断
     * @param s
     * @param i
     * @param j
     */
    public static void helper(String s,int i,int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            res++;
            i--;
            j++;
        }
    }

    public static void main(String[] args) {
        String s = "fdsklf";
        System.out.println(countSubstrings(s));
    }
}
