package _02_LeetCode_Solution.String.No392;

/**
 * 392. Is Subsequence
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null && t == null)
            return true;
        if(s != null && t == null)
            return false;
        int lenS = s.length();
        int lenT = t.length();
        int i = 0, j = 0;
        while(i < lenS && j < lenT){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return (i >= lenS);
    }
}
