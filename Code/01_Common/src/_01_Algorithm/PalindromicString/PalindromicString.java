package _01_Algorithm.PalindromicString;

/**
 * 最长回文子串
 *  对于字符串abcdedcb找到最长的回文子串，bcdedcb
 *  [1]确定回文穿中心
 *  [2]时间复杂度为O(n^2)
 */
public class PalindromicString {
    private static String res = "";

    public static String longestPalindrome(String s) {
        for(int i=0; i < s.length(); i++){
            helper(s,i,i);
            helper(s,i,i+1);
        }
        return res;
    }

    private static void helper(String s,int i,int j){
        while(i>=0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            if(j-i+1 > res.length()){
                res = s.substring(i,j+1);
            }
            i--;
            j++;
        }
    }

    public static void main(String[] args) {
        String s = "abcdedcb";
        System.out.println(longestPalindrome(s));
    }
}
