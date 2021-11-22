package _02_LeetCode_Solution.String.No438;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 使用滑动窗口求解
 */
public class Solution2 {

//    public static List<Integer> findAnagrams(String s, String p) {
//        List<Integer> res = new ArrayList<>();
//
//        return res;
//    }

    public static List<Integer> findAnagrams(String s, String p) {
//        ArrayList<Integer> result = new ArrayList<>();
//        if(s == null || p == null) return result;
//        int left = 0,right =0,count = p.length();
//        int[] map = new int[256];
//        char[] sc = s.toCharArray();
//        for (char c : p.toCharArray()) map[c] ++;
//        while (right < s.length()) {
//            if (map[sc[right++]]-->=1) count --;
//            if (count == 0) result.add(left);
//            if (right - left == p.length() && map[sc[left++]]++ >=0) count++;
//        }
//        return result;

        List<Integer> res = new ArrayList<>();
        //0. 边界条件
        if(s == null || p == null){
            return res;
        }
        //1. 初始化数组
        int[] map = new int[26];
        for(char c : p.toCharArray()) map[c - 'a']++;
        //2. 窗口滑动
        int i = 0, j = 0,count = p.length();
        char[] sc = s.toCharArray();
        while(j < s.length()){
            //元素是否在map中
            if(map[sc[j]-'a'] >= 1){
                count--;
            }
            map[sc[j]-'a']--;
            j++;

            //是否满足边界条件
            if(count == 0){
                res.add(i);
            }
            //左边界推进
            if(j-i == p.length() && map[sc[i] - 'a'] >= 0){
                if(map[sc[i] - 'a'] >= 0){
                    count++;
                }
                map[sc[i] - 'a']++;
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> res = findAnagrams(s,p);
    }
}
