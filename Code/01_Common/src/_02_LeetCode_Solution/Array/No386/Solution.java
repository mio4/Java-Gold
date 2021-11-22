package _02_LeetCode_Solution.Array.No386;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. Lexicographical Numbers
 * 拿比如199 200举例子
 * （1）输出是 1->10->100->101...109->110->...199->2
 * （2）首先做DFS，当i < n时再做横向增加
 */
class Solution {
    private List<Integer> result = new ArrayList<Integer>();
    public List<Integer> lexicalOrder(int n) {
        addNumber(1,n);
        return result;
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
