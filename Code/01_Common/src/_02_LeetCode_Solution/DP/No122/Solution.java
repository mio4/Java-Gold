package _02_LeetCode_Solution.DP.No122;

class Solution {
    public static int maxProfit(int[] prices) {
        int maxPro = 0;

        if(prices == null || prices.length == 0)
            return maxPro;

        int i  = 0, begin = 0, end = 0;
        while(i < prices.length-1){
            if(prices[i] < prices[i+1]){
                end++;
            }
            else{
                maxPro += prices[end] - prices[begin];
                begin = i+1;
                end = i+1;
            }
            i++;
        }
        maxPro += prices[end] - prices[begin];

        return maxPro;
    }

    public static void main(String[] args){
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
        int[] nums2 = {7,6,4,3,1};
        System.out.println(maxProfit(nums2));
        int[] nums3 = {1,2,3,4,5};
        System.out.println(maxProfit(nums3));
    }
}