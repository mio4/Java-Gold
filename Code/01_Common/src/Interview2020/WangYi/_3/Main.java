package Interview2020.WangYi._3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 字典序最小的数组
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for(int i=0; i < len; i++){
            nums[i] = sc.nextInt();
        }

        //直接排序，输出70%
        Arrays.sort(nums);


        //O(n^2)交换，输出30%
//        for(int i=0; i < len; i++){
//            for(int j=i+1; j < len; j++){
//                if((nums[i]+nums[j])%2 == 1 && nums[i] > nums[j]){
//                    swap(nums,i,j);
//                }
//            }
//        }

        //多次排序，输出30%
//        boolean flag = true;
//        while(flag){
//            flag = false;
//            for(int i=0; i < len; i++){
//                for(int j=0; j < len; j++){
//                    if((nums[i]+nums[j])%2==1 && (
//                            (i < j && nums[i] > nums[j]) || (i > j && nums[i] < nums[j])) ){
//                        swap(nums,i,j);
//                        flag = true;
//                    }
//                }
//            }
//        }

        for(int i : nums){
            System.out.print(i + " ");
        }

    }

    private static void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
