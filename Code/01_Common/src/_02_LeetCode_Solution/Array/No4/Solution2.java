package _02_LeetCode_Solution.Array.No4;

/**
 * 时间复杂度为O(log(m+n))
 * 二分的时间复杂度为log2N
 * 1.这道题仔细观察
 */
class Solution2 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if((len & 0x01) == 1) //如果是奇数
            return findKth(nums1,nums2,0,nums1.length,0,nums2.length,len/2+1);
        else //如果是偶数
            return (findKth(nums1,nums2,0,nums1.length,0,nums2.length,len/2)
                    + findKth(nums1,nums2,0,nums1.length,0,nums2.length,len/2+1))/2;
    }

    //k:两个数组中的第K小数
    //退出条件：
    //1.nums1子数组长度为0，则第K个直接在nums2中找
    //2.如果K = 1则只需要找到最小的元素【在两个数组之间】
    public static double findKth(int[] nums1, int[] nums2, int start1, int len1, int start2, int len2,int k){
        if(len1 > len2) //规定第一个数组的长度永远是更小的
            return findKth(nums2,nums1,start2,len2,start1,len1,k);
        if(len1 == 0)
            return nums2[start2+k-1];
        if(k == 1)
            return Math.min(nums1[start1],nums2[start2]);

        int p,q;
        p = Math.min(k/2,len1);
        q = k - p;
        if(nums1[start1+p-1] == nums2[start2+q-1])
            return nums1[start1+p-1];
        else if(nums1[start1+p-1] > nums2[start2+q-1])
            return findKth(nums1,nums2,start1,len1,start2+q,len2-q,k-q);
        else
            return findKth(nums1,nums2,start1+p,len1-p,start2,q,k-p);
    }

    public static void main(String[] args){
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
        int[] nums3 = {1,3};
        int[] nums4 = {2};
        System.out.println(findMedianSortedArrays(nums3,nums4));
        int[] nums5 = {3,4};
        int[] nums6 = {1,2,5};
        System.out.println(findMedianSortedArrays(nums5,nums6));
        int[] nums7 = {1};
        System.out.println(findMedianSortedArrays(nums7,nums7));
    }
}
