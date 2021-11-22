package _02_LeetCode_Solution.String.No5;

/**
 * 时间复杂度为O(n^2)
 * （1）对于每一个字符，从中间开始往左右两边找
 *  对于...moon..这种偶数回文，要从o和o开始
 *  对于...bab...这种奇数回文，要从a和a开始
 * （2）边界条件：null | "" | 单个字符
 * TODO 回文问题的马拉车算法
 */
class Solution2 {
    public static String longestPalindrome(String s) {
        if(s.length() < 2)
            return s;
        int len = s.length();
        String a,b,res = "";
        for(int i=0; i < len; i++){
           a = isPalindromic(s,i,i,len);
           b = isPalindromic(s,i,i+1,len);
           if(a.length() > res.length() || b.length()>res.length())
               res = (a.length() > b.length())?a:b;
        }
        return res;
    }

    public static String isPalindromic(String s,int left,int right, int len){
        while(left>=0 && right<len && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        if(right == left+1)
            return "";
        else
            return s.substring(left+1,right);
    }

    public static void main(String[] args){
        System.out.println(longestPalindrome("babac"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("bb"));
    }
}
