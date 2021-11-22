package _01_Algorithm;

/**
 * Longest Common SubSequence (LCS) 最长公共子序列问题
 * dp[i][j]，A字符串前i个和j字符串前j个的LCS
 * dp[i][j] =
 *              0,( i==0 || j==0)
 *              dp[i-1][j-1]+1 (a[i] = b[j])
 *              max(dp[i-1][j],dp[i][j-1]) (a[i] != b[j])
 * 求dp[a.length()][b.length()]
 */
public class LongestCommonSubsequence {
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public static int longestCommonSubsequence(String A, String B) {
        int[][] dp = new int[A.length()+1][B.length()+1];
        //初始化数组

        //迭代求值
        //i表示前i个元素，i为1时，判断s[0],所以为i-1
        for(int i=1; i <= A.length(); i++){
            for(int j=1; j <= B.length(); j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[A.length()][B.length()];
    }

    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "EACB";
        System.out.println(longestCommonSubsequence(s1,s2));
    }
}
