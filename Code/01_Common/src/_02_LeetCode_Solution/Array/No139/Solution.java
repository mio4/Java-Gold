package _02_LeetCode_Solution.Array.No139;

import java.util.Arrays;
import java.util.List;

/**
 * 直接使用递归会造成超时
 */
class Solution {
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean mark = false;
        for(String dict : wordDict){
            int len = dict.length();
            if (len <= s.length() && s.substring(0, len).equals(dict)) {
                if(len == s.length())
                    return true;
                mark = mark | wordBreak(s.substring(len), wordDict);
            }
        }
        return mark;
    }

    public static void main(String[] args) {
        //test substring
//        String s = "123456";
//        System.out.println(s.substring(0,2));

        List<String> wordDict = Arrays.asList("leet","code");
        System.out.println(wordBreak("leetcode",wordDict));

        List<String> wordDict2 = Arrays.asList("apple","pen");
        System.out.println(wordBreak("applepenapple",wordDict2));

        List<String> wordDict3 = Arrays.asList("cats","dog","sand","and","cat");
        System.out.println(wordBreak("catsandog",wordDict3));
    }
}
