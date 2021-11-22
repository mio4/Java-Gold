package _02_LeetCode_Solution.String.No438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Brute Force - TLE
 */
class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        if(s == null || p == null){
            return res;
        }

        p = convertString(p);
        for(int i=0; i < s.length() - p.length() + 1; i++){
            String t = s.substring(i,i+p.length());
            if(isEqual(t,p)){
                res.add(i);
            }
        }

        return res;
    }


    public static boolean isEqual(String s1,String s2){
        return convertString(s1).equals(s2);
    }


    public static String convertString(String s){ //String排序
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> res = findAnagrams(s,p);

    }
}
