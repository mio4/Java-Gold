package _02_LeetCode_Solution.String.No9;

/**
 * At first, we convert the integer to a _02_LeetCode_Solution.String, but in this way we use new Space O(n)
 * Not good enough
 */
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        else if(x == 0)
            return true;
        else{
            String s = String.valueOf(x);
            for(int i=0,j=s.length()-1; i<=j;i++,j--){
                if(s.charAt(i) != s.charAt(j))
                    return false;
            }
            return true;
        }
    }
}
