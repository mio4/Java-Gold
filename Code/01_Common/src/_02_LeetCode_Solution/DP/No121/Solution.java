package _02_LeetCode_Solution.DP.No121;

class Solution {
    public int maxProfit(int[] prices) {
        int maxPro = 0;
        for(int i=0; i < prices.length-1; i++){
            for(int j=i+1; j < prices.length;j++){
                int minus = prices[j] - prices[i];
                if(minus > maxPro)
                    maxPro = minus;
            }
        }
        return maxPro;
    }
}
