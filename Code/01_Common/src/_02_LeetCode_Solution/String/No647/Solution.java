package _02_LeetCode_Solution.String.No647;

/**
 * 1. 获取所有的子字符串
 * 2. 判断是否是回文字符串
 * 3. 统计结果
 *
 * 时间复杂度O(n^3)
 */
class Solution {
    public static int countSubstrings(String s) {
        int res = 0;
        for(int i=0; i < s.length(); i++){
            for(int j=i+1; j <= s.length(); j++){
                String t = s.substring(i,j);
                if(isPalindrome(t)) res++;
            }
        }
        return res;
    }

    public static void test(String s){
        for(int i=0; i < s.length(); i++){
            for(int j=i+1; j <= s.length(); j++){
                String t = s.substring(i,j);
                System.out.println(t);
            }
        }
    }

    public static boolean isPalindrome(String s){
        for(int i=0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "abc";
        System.out.println(countSubstrings(s));

    }
}
