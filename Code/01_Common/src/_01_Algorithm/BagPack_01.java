package _01_Algorithm;

import java.util.Arrays;

/**
 * 01背包问题
 * （1）每个物品只能使用一次
 * （2）在保证不超过背包容量的情况下，放价值总和最大的物品
 *      [1]找到最大的价值
 *      [2]找到最大价值对应的商品组合
 *
 * 动态规划：
 * （0）对于问题的抽象
 * （1）最优子结构
 *      dp[i][j]：判断到第i个物品时，背包容量为j的最大价值
 * （2）状态转移方程:
 *      dp[i][j] =
 *                  dp[i-1][j] (weight[i] > j)
 *                  max{dp[i-1][j],dp[i-1][j-weight[i]] + values[j]} (weight[j] <= j)
 * （3）从结果反推是否使用了某个物品（根据状态转移方程）
 *
 */
public class BagPack_01 {

    private static int[][] dp;
    private static int[] weights = {0,2,3,4,5};
    private static int[] values = {0,3,4,5,6};
    private static int[] item;

    public static int getMaxValue(int vol){
        dp = new int[weights.length][vol+1];
        //初始化数组
        //递归求解
        for(int i=1; i < weights.length; i++){
            for(int j=1; j < vol+1; j++){
                if(weights[i] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weights[i]] + values[i]);
                }
            }
        }


        return dp[weights.length-1][vol];
    }

    public static void findItem(int i,int j){
        if(i > 0){
            if(dp[i][j] == dp[i-1][j]){
                item[i] = 0;
                findItem(i-1,j);
            }
            else if(j >= weights[i] && dp[i][j] == dp[i-1][j - weights[i]]+values[i]){
                item[i] = 1;
                findItem(i-1,j-weights[i]);
            }
        }
    }

    public static void printMiddle(){
        //打印中间结果
        System.out.println("---中间计算结果---");
        for(int i=0; i < weights.length; i++){
            for(int j=0; j <= 8; j++){
                System.out.print(dp[i][j] + " ");
                if(j == 8){
                    System.out.println();
                }
            }
        }
    }


    public static void main(String[] args){
        item = new int[5];
        System.out.println(getMaxValue(8));
        findItem(weights.length-1,8);
        System.out.println(Arrays.toString(item));
        printMiddle();
    }
}
