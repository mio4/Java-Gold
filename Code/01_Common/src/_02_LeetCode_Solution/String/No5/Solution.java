package _02_LeetCode_Solution.String.No5;

/**
 * 5. Longest Palindromic Substring
 * 朴素解法：时间复杂度为O(n^3)【弃】
 * Time Limit Exceeded 本题有时间限制，
 */
class Solution {
    public static String longestPalindrome(String s) {
        if(s == null)
            return null;
        if("".equals(s))
            return "";
        int i,j;
        int max_len = 0;
        String res = s.substring(0,1);
        for(i=0; i < s.length(); i++){
            for(j=i; j < s.length(); j++){
                if(isPalindromic(s.substring(i,j+1)) && max_len < j-i+1){
                    res = s.substring(i,j+1);
                    max_len = j-i;
                }
            }
        }
        return res;
    }

    public static boolean isPalindromic(String s){
        int i,j;
        for(i=0,j=s.length()-1; i <= j; i++,j--){
            if(s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(longestPalindrome("babac"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("bb"));
    }
}
