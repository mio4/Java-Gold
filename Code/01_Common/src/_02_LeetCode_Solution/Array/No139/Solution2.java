package _02_LeetCode_Solution.Array.No139;

import java.util.Arrays;
import java.util.List;

/**
 * 1. dp[i]为true：字符串[0,i)可以用字典元素表示，dp[len]：[0,len)也就是s可以用字典元素表示
 * 2. dp[0]表示空字符串可以用字典元素表示
 * 3. 首先是固定i，使用j(j的作用是实现递归迭代)
 *  dp[j] == true表示(0,j)可以被表示，剩下的如果也在字典集合中，那么dp[i] = true
 * 4. 迭代的终止条件是i == s.length()
 */
class Solution2 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1]; //字符串长度为空&字符串长度刚好合适
        dp[0] = true;
        for(int i = 0; i <= len; i++){
            for(int j=0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[len];
    }

    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("leet","code");
        System.out.println(wordBreak("leetcode",wordDict));

        List<String> wordDict2 = Arrays.asList("apple","pen");
        System.out.println(wordBreak("applepenapple",wordDict2));

        List<String> wordDict3 = Arrays.asList("cats","dog","sand","and","cat");
        System.out.println(wordBreak("catsandog",wordDict3));
    }
}
