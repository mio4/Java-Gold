package other.KaoYan.Chap6;

/**
 * （1）只能在有序的数组中使用
 * （2）时间复杂度为O(log2N)
 */
public class BinarySearch {

    public static int binarySearch(int[] nums,int low, int high,int k){
        int mid = (low+high)/2;
        if(k == nums[mid])
            return mid;
        else if(k < nums[mid])
            return binarySearch(nums,low,mid-1,k);
        else
            return binarySearch(nums,mid+1,high,k);
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(nums,0,nums.length,3));
        System.out.println(binarySearch(nums,0,nums.length,5));
        System.out.println(binarySearch(nums,0,nums.length,9));
    }
}
