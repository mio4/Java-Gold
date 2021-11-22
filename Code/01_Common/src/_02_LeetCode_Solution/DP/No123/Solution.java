package _02_LeetCode_Solution.DP.No123;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public static int maxProfit(int[] prices) {
        int maxPro = 0;

        if(prices == null || prices.length == 0)
            return maxPro;

        int i  = 0, begin = 0, end = 0;
        List<Integer> res = new ArrayList<Integer>();
        while(i < prices.length-1){
            if(prices[i] < prices[i+1]){
                end++;
            }
            else{
                res.add(prices[end] - prices[begin]);
                //maxPro += prices[end] - prices[begin];
                begin = i+1;
                end = i+1;
            }
            i++;
        }
        //maxPro += prices[end] - prices[begin];
        res.add(prices[end] - prices[begin]);
        Collections.sort(res);
        if(res.size() == 0)
            return maxPro;
        else if(res.size() == 1)
            return res.get(0);
        else
            return res.get(res.size()-1) + res.get(res.size()-2);
    }

    public static void main(String[] args){

    }
}
