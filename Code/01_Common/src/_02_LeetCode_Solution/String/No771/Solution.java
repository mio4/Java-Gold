package _02_LeetCode_Solution.String.No771;

/**
 * 时间复杂度为O(m*n),其中m和n分别是字符串J和字符串S的长度
 * Brute Force
 */
class Solution {
    public int numJewelsInStones(String J, String S) {
        int lenJ = J.length();
        int lenS = S.length();
        int count=0;
        for(int i=0; i < lenJ; i++){
            for(int j=0; j < lenS; j++){
                if(S.charAt(j) == J.charAt(i))
                    count++;
            }
        }
        return count;
    }
}
