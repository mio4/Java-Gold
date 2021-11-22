package _02_LeetCode_Solution.Permutation.No567;

import java.util.Arrays;

/**
 * 其实这是一道滑动窗口的题hhh
 * 判断是否是全排列->判断相同长度范围内字母出现的个数->使用滑动窗口个来保证范围是相同的
 * 方法太巧妙了 不得不佩服
 */
class Solution2 {
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        int[] m1 = new int[128];
        int[] m2 = new int[128];
        int len1 = s1.length();
        int len2 = s2.length();
        for(int i=0; i < len1; i++){
            m1[s1.charAt(i)]++;
            m2[s2.charAt(i)]++;
        }
        if(Arrays.equals(m1,m2)) //s1和s2前n个字符出现的频率和类型是相同的
            return true;
        for(int i=len1; i < len2; i++){
            m2[s2.charAt(i)]++;
            m2[s2.charAt(i-len1)]--;
            if(Arrays.equals(m1,m2))
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1,s2));
    }
}
