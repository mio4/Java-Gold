package _02_LeetCode_Solution.Interview._88;

public class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int offset = 0;

        while(p1 < m+offset && p2 < n){
            if(nums1[p1] <= nums2[p2]){
                p1++;
            }
            else{
                for(int i=m+offset-1; i >= p1; i--){
                    nums1[i+1] = nums1[i];
                }
                nums1[p1] = nums2[p2];
                offset++;
                p1++;
                p2++;
            }
        }

        int i = 0;
        while(p2 < n){
            nums1[m+offset+i] = nums2[p2];
            i++;
            p2++;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums1 = {4,0,0,0,0,0};
        int[] nums2 = {1,2,3,5,6};
        merge(nums1,1,nums2,5);
    }
}
