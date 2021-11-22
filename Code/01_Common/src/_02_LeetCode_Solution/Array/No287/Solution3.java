package _02_LeetCode_Solution.Array.No287;

/**
 * FIXME 奇淫巧技
 * 判断链表是否有环的改装version
 */
class Solution3 {
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while(fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] a = {1,3,4,2,2};
        System.out.println(findDuplicate(a));
    }
}
