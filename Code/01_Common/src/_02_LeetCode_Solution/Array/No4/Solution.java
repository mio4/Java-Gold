package _02_LeetCode_Solution.Array.No4;

/**
 * 朴素算法：时间复杂度为O(m+n)，空间复杂度为O(n+m)
 * 这个算法的易错点主要在于数组的拷贝
 * （i）先拷贝nums1和nums2数组中的一部分，然后将剩下的数组拷贝过去
 * （ii）直接可以拿到新数组的中位数
 * 这种解法一点意思都没有，空间复杂度和时间复杂度都很大，不考虑
 */
class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums3 = new int[m+n];
        int index1 = 0,index2 = 0,index3 = 0;
        while(index3 < m+n && index1 < m && index2 < n){
            if(nums1[index1] < nums2[index2]){
                nums3[index3++] = nums1[index1++];
            }
            else if(nums1[index1] == nums2[index2]){
                nums3[index3++] = nums1[index1++];
                nums3[index3++] = nums2[index2++];
            }
            else {
                nums3[index3++] = nums2[index2++];
            }
        }
        while(index1 <= m-1){
            nums3[index3++] = nums1[index1++];
        }
        while(index2 <= n-1){
            nums3[index3++] = nums2[index2++];
        }

        if((m+n) % 2 == 0)
            return  (double)(nums3[(m+n)/2-1] + nums3[(m+n)/2])/2;
        else
            return nums3[(m+n)/2];
    }

    public static void main(String[] args){
        //int[] nums1 = {1,2};
        //int[] nums2 = {3,4};
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}