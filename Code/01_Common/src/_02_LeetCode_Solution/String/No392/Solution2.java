package _02_LeetCode_Solution.String.No392;

/**
 * 优化，使用index方法查找【可能会用hash，提高速度】
 */
class Solution2 {
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0)
            return true;
        int cur = 0;
        for(char ch : s.toCharArray()){
            cur = t.indexOf(ch,cur);
            if(cur == -1)
                return false;
            cur++;
        }
        return true;
    }
}
