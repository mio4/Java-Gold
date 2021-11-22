package _02_LeetCode_Solution.Array.No287;

/**
 * TODO 理解本题的二分查找 too hard...
 *
 * 要求
 *  时间复杂度 < O(n^2) -> 搜索方法时间复杂度控制，联想到使用二分查找
 *  空间复杂度 O(1) -> 不能适用额外的空间，比如建造hashmap
 *  不能改变原有数组 -> 不能对数组进行排序
 *
 *
 */
public class Solution2 {
    public static int findDuplicate(int[] nums) {
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,3,4,2,2};
        System.out.println(findDuplicate(a));
    }
}
