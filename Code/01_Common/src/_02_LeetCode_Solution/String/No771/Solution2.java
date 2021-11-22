package _02_LeetCode_Solution.String.No771;

/**
 * 拿时间换空间
 * 时间复杂度为O(max(m,n))
 */
class Solution2 {
    public int numJewelsInStones(String J, String S) {
        int[] index = new int[127];
        for(int i=0; i < J.length();i++){
            index[J.charAt(i)] = 1;
        }
        int count = 0;
        for(int i=0; i < S.length();i++){
            if(index[S.charAt(i)] == 1)
                count++;
        }
        return count;
    }
}
