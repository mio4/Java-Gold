package _02_LeetCode_Solution.Permutation.No567;

/**
 * TODO NOT FINISHED
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null)
            return true;
        if(s1.length()==0 && s2.length()!=0)
            return true;
        int i=0,j=0,left,right;
        while(j < s2.length()){
            while(s1.charAt(i) != s2.charAt(j)) j++;
            left = j;
            right = j;
            if(j-1 >= 0 && s1.charAt(i) == s2.charAt(left-1)) {i++;left--;}
            //if(i == s1.length()-1)
        }
        return false;
    }

    public static void main(String[] args){

    }
}
