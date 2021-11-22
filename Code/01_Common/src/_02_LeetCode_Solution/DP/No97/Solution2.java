package _02_LeetCode_Solution.DP.No97;

/**
 * 目的：知道为什么要这样构建数组而不只是如何去使用构建好的数组
 * 动态规划：构建一个二维数组
 * 二维数组dp[i][j]的值表示对s1的前i个字符和s2的前j个字符能否成功匹配的情况
 */
class Solution2 {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;
        boolean[][] mark = new boolean[s1.length()+1][s2.length()+1];
        mark[0][0] = true;
        //构建第一行
        for(int i=1; i < s2.length()+1; i++){
            mark[0][i] = mark[0][i-1] & s2.charAt(i-1) == s3.charAt(i-1);
        }
        //构建第一列
        for(int i=1; i < s1.length()+1; i++){
            mark[i][0] = mark[i-1][0] & s1.charAt(i-1) == s3.charAt(i-1);
        }
        //构建剩余的数组
        for(int i=1; i < s1.length()+1;i++){
            for(int j=1; j < s2.length()+1;j++){
                mark[i][j] = (mark[i-1][j] && s1.charAt(i-1)==s3.charAt(i-1+j))
                        || (mark[i][j-1] && s2.charAt(j-1)==s3.charAt(j-1+i));
            }
        }
        return mark[s1.length()][s2.length()];
    }

    public static void main(String[] args){
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
