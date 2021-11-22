package _01_Algorithm.PalindromicString;

/**
 * 最长回文子串——动态规划解法
 * dp[i][j]表示字符串s从i开始到j（包含i和j）是回文字符串
 *
 * 初始化
 * dp[i][i] = 1;
 * dp[i][i+1] = 1 when s[i] = s[i+1]
 *
 * 迭代
 * dp[i][j] =
 *              dp[i+1][j-1] when s[i] = s[j]
 *              0 when s[i] != s[j]
 */
public class PalindromicStringDP {

    public static String longestPalindrome(String s) {
        if(s == null || s.equals("")){
            return s;
        }

        int left = 0,right = 0,len = 0;
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0; i < s.length()-1; i++){
            dp[i][i] = 1;
            if(s.charAt(i) == s.charAt(i+1)){
                left = i;
                right = i+1;
                len = 2;
                dp[i][i+1] = 1;
            }
        }
        dp[s.length()-1][s.length()-1] = 1;

        for(int l=3; l < s.length()+1; l++){ //判定长度
            for(int i=0; i < s.length()+1-l; i++){ //判定起点
                int j = i+l-1; //判定终点
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                if(dp[i][j]==1 && l > len){
                    left = i;
                    right = j;
                    len = l;
                }
            }
        }
        return s.substring(left,right+1);
    }

    public static void main(String[] args) {
        String s = "abcdedcb";
        System.out.println(longestPalindrome(s));

        String s2 = "babab";
        System.out.println(longestPalindrome(s2));

        String s3 = "cbbd";
        System.out.println(longestPalindrome(s3));

        String s4 = "ccc";
        System.out.println(longestPalindrome(s4));
    }
}
