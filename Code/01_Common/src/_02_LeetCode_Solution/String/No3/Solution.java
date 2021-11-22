package _02_LeetCode_Solution.String.No3;

/**
 * 3. Longest Substring Without Repeating Characters
 * 这道题是真的经典
 * （1）如何检查字符是否已经出现过？
 *  记录字符串开始的位置以及每个已经出现的字符的下一个开始位置，如果字符已经出现，那么count[ch]一定刚好比subStart大1
 * （2）什么时候更新最大的len
 *  len是一个非减函数【使用Math.max()更新保证】，每次检查当前字符串开始到目前字符的长度和历史最长长队对比
 *
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[127];
        int max_len = 0;
        int subStart = 0;
        for(int i=0 ;i < s.length(); i++){
            char ch = s.charAt(i);
            subStart = Math.max(subStart,count[ch]);
            count[ch] = i+1;
            max_len = Math.max(max_len,i - subStart + 1);
        }
        return max_len;
    }
}
