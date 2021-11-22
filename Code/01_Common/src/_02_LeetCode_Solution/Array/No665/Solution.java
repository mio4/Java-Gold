package _02_LeetCode_Solution.Array.No665;

class Solution {
    public static boolean checkPossibility(int[] nums) {
        if(!check(nums,0) && !check(nums,1))
            return false;
        return true;
    }

    public static boolean check(int n[],int flag){
        int i;
        int nums[] = new int[n.length];
        for(i=0; i < n.length;i++){
            nums[i] = n[i];
        }

        int len = nums.length;
        for(i = 0; i < len-1; i++){
            if(nums[i] > nums[i+1]){
                if(flag == 0)
                    nums[i] = nums[i+1]-1;
                else if(flag == 1)
                    nums[i+1] = nums[i]+1;
                break;
            }
        }
        for(i = 0; i < len-1; i++){
            if(nums[i] > nums[i+1])
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        int a1[] = {4,2,3};
        int a2[] = {4,2,1};
        int a3[] = {3,4,2,3};
        System.out.println(checkPossibility(a1));
        System.out.println(checkPossibility(a2));
        System.out.println(checkPossibility(a3));
    }
}
