package Interview2020.WangYi._2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        while(cnt > 0){
            int numCnt = sc.nextInt();
            int[] nums = new int[numCnt];
            for(int i=0; i < nums.length; i++){
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);
            if(nums[nums.length-1] < nums[nums.length-2] + nums[0]){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }

            cnt--;
        }
    }
}
