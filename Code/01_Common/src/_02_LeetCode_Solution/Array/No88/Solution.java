package _02_LeetCode_Solution.Array.No88;

import java.util.Arrays;

/**
 * WA
 */
class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        int index = 0;
//        int i = 0;
//        while(i < n){
//            if(index < m) {
//                if (nums2[i] > nums1[index]) {
//                    index++;
//                } else if (nums2[i] <= nums1[index]) {
//                    for (int k = index + 1; k < m; k++)
//                        nums1[k + 1] = nums1[k];
//                    index++;
//                    nums1[index] = nums2[i];
//                    i++;
//                }
//            }
//            else{
//                nums1[index] = nums2[i];
//                index++;
//                i++;
//            }
//        }
    }

    public static void main(String[] args){
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1,3,nums2,3);

        int[] n1 = {0};
        int[] n2 = {1};
        merge(n1,0,n2,1);
        System.out.println(Arrays.toString(nums1));
    }
}
