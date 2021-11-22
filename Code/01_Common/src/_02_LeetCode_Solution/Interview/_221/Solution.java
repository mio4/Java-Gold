package _02_LeetCode_Solution.Interview._221;

class Solution {
    public static int maximalSquare(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max_len = 0;
        for(int i=0; i < matrix.length; i++){
            for(int j=0; j < matrix[0].length; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = matrix[i][j] - '0';
                }
                else{
                    if(matrix[i][j] == '1'){
                        int min = Math.min(dp[i-1][j-1],dp[i-1][j]);
                        min = Math.min(min,dp[i][j-1]);
                        dp[i][j] = min + 1;
                    }
                }
                max_len = Math.max(max_len,dp[i][j]);
            }
        }
        return max_len*max_len;
    }

    public static void main(String[] args) {
        char[][] a = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(a));
    }
}
