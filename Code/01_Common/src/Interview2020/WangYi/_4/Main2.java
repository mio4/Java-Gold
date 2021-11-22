package Interview2020.WangYi._4;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int queryCnt = sc.nextInt();
        int[] nums = new int[cnt];
        for(int i=0; i < cnt; i++){
            nums[i] = sc.nextInt();
        }

        int[] query = new int[queryCnt];
        for(int i=0; i < queryCnt; i++){
            query[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        for(int i=0; i < queryCnt; i++){
            int limit = query[i];
            //二分查找
            int left = 0;
            int right = cnt-1;
            while(left < right){
                int mid = (left + right)/2;
                if(nums[mid] < limit){
                    left = mid + 1;
                }
                else if(nums[mid] == limit){
                    break;
                }
                else{
                    right = mid - 1;
                }
            }
            if(left == 0 && right == 0){
                //TODO
            }
        }


    }
}
