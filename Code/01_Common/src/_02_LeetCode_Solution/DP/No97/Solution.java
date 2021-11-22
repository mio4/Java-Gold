package _02_LeetCode_Solution.DP.No97;

/**
 * 97. Interleaving String
 * 不考虑顺序，错误解法【弃】
 */
class Solution {
    public static boolean isInterleave(String s1, String s2, String s3) {
        //边界情况
        if(s1 == null && s2 == null && s3 == null)
            return true;
        else if(s1 == null && s2 != null && s3 != null){
            if(s2.equals(s3)) return true;
            else return false;
        }
        else if(s1 != null && s2 == null && s3 != null){
            if(s1.equals(s3)) return true;
            else return false;
        }
        else if(s1 == null && s2 == null && s3 != null){
            return false;
        }
        //一般情况
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        int p1 = 0,p2 = 0,p3 = 0;
        while(p1 < len1 && p2 < len2 && p3 < len3){
            if(s3.charAt(p3) == s1.charAt(p1)){
                p1++; p3++;
            }
            else if(s3.charAt(p3) == s2.charAt(p2)){
                p2++; p3++;
            }
            else{
                return false;
            }
        }
        if(p1 == len1 && p2 == len2 && p3 != len3)
            return false;
        if(p1 == len1 && p2 != len2){
            while(p3 < len3){
                if(s3.charAt(p3) == s2.charAt(p2)){
                    p3++; p2++;
                }
                else
                    return false;
            }
        }
        if(p1 != len1 && p2 == len2){
            while(p3 < len3){
                if(s3.charAt(p3) == s1.charAt(p1)){
                    p3++; p1++;
                }
                else
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        isInterleave("aabcc",
                "dbbca",
                "aadbbcbcac");
    }
}
