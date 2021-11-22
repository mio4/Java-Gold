package _02_LeetCode_Solution.Array.No611;

class Solution2 {
    public static int triangleNumber(int[] nums) {
        int cnt = 0;
        for(int a=0; a < nums.length ;a++){
            for(int b=a+1,c=a+2; c < nums.length; c++){
                while(b < c  && c < nums.length && nums[a]+nums[b]<=nums[c])
                    c++;
                cnt+=c-b;
            }
        }
        return cnt;
    }

    public static void main(String[] args){
        int[] nums = {2,2,3,4};
        System.out.println(triangleNumber(nums));
    }
}
