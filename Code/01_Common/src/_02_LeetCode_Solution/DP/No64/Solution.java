package _02_LeetCode_Solution.DP.No64;

/**
 * 上来就用DP的思路是正确的
 * 不过对于二维数组的操作一定要分清楚arr.length和arr[0].length之间的区别
 */
class Solution {
    public static int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i=1; i < grid[0].length;i++)
            dp[0][i] = dp[0][i-1]+grid[0][i];
        for(int i=1; i < grid.length;i++)
            dp[i][0] = dp[i-1][0]+grid[i][0];
        for(int i=1; i < grid.length; i++){
            for(int j=1; j < grid[0].length; j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args){
        int[][] arr = {{1,2,5},{3,2,1}};
        System.out.println(minPathSum(arr));
    }
}
