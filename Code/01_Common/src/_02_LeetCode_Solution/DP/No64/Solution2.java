package _02_LeetCode_Solution.DP.No64;

/**
 * 优化命名风格
 */
class Solution2 {
    public int minPathSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int[][] dp = new int[height][width];
        dp[0][0] = grid[0][0];
        for(int i=1; i < width; i++)
            dp[0][i] = dp[0][i-1] + grid[0][i];
        for(int i=1; i < height; i++)
            dp[i][0] = dp[i-1][0] + grid[i][0];
        for(int i=1; i < height; i++){
            for(int j=1; j < width; j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[height-1][width-1];
    }
}
