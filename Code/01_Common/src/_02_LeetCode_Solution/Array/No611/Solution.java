package _02_LeetCode_Solution.Array.No611;

class Solution {
    public static int triangleNumber(int[] nums) {
        int cnt = 0;
        for(int a = 0; a < nums.length; a++){
            for(int b = a+1; b < nums.length; b++){
                for(int c = b+1; c < nums.length; c++){
                    if(isValid(nums[a],nums[b],nums[c]))
                        cnt++;
                }
            }
        }
        return cnt;
    }

    public static boolean isValid(int a, int b, int c){
        return (a + b > c && a + c > b && b + c > a);
    }

    public static void main(String[] args){
        int[] nums = {2,2,3,4};
        System.out.println(triangleNumber(nums));
    }
}
