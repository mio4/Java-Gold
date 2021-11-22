package _02_LeetCode_Solution.DP.No120;

import java.util.List;

/**
 * 最开始看见这道题是在大一C语言第二课堂上，当时什么也不懂，结果就是到了如今大三对这种题还是没有办法
 * TODO stay hungry and stay foolish
 * 直接使用原数组作为动态规划需要的数组空间
 * 从上往下遍历，将遍历的结果存放到数组中，这样数组就充当了记忆的作用
 * （1）处于左边界：t[i][j] = t[i-1][j] + t[i][j]
 * （2）一般情况 t[i][j] = min(t[i-1][j-1],t[i-1][j]) + t[i][j]
 * （3）处于右边界 t[i][j] = t[i-1][j-1] + t[i][j]
 *
 * API：
 * list.set(index,value)
 * list.get().get()...
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int minSum = Integer.MAX_VALUE;
        for(int i=1; i < len; i++){
            for(int j=0; j < triangle.get(i).size();j++){
                if(j == 0)
                    triangle.get(i).set(j,triangle.get(i-1).get(0)+triangle.get(i).get(0));
                else if(j == triangle.get(i).size()-1)
                    triangle.get(i).set(j,triangle.get(i-1).get(j-1)+triangle.get(i).get(j));
                else
                    triangle.get(i).set(j,Math.min(triangle.get(i-1).get(j-1),triangle.get(i-1).get(j))+triangle.get(i).get(j));
            }
        }
        for(int i=0; i < triangle.get(len-1).size(); i++){
            minSum = Math.min(minSum,triangle.get(len-1).get(i));
        }
        return minSum;
    }
}
