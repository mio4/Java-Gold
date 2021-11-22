package _02_LeetCode_Solution.Array.No28;

class Solution {
    public static int strStr(String haystack, String needle) {
        String s1 = haystack;
        String s2 = needle;
        //边界条件
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1 < l2){
            return -1;
        }

        return 1;
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "ll";
        System.out.println(strStr(s1,s2));
    }
}
