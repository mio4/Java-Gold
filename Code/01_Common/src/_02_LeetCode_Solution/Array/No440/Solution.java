package _02_LeetCode_Solution.Array.No440;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用递归会Time Limit Exceeded
 */
class Solution {
    private List<Integer> result = new ArrayList<Integer>();
    public int findKthNumber(int n, int k) {
        addNumber(1,n);
        return result.get(k);
    }
    public void addNumber(int i,int n){
        if(i > n)
            return;
        result.add(i);
        addNumber(i*10,n);
        if(i%10 != 9)
            addNumber(i+1,n);
    }
}
