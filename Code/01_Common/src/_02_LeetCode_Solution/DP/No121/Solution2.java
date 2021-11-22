package _02_LeetCode_Solution.DP.No121;

class Solution2 {
    public int maxProfit(int[] prices) {
        int maxPro = 0;
        int tmp = 0;

        for(int i=0; i < prices.length-1; i++){
            int cur = prices[i+1] - prices[i];
            tmp += cur;
            if(tmp < 0)
                tmp = 0;
            if(tmp > maxPro)
                maxPro = tmp;
        }

        return maxPro;
    }

    public static void main(String[] args){

    }
}
