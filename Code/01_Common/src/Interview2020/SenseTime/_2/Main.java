package Interview2020.SenseTime._2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0; i < N; i++){
            nums[i] = sc.nextInt();
        }

        int max = 0;
        for(int i=1; i < N-1; i++){
            int left = i;
            int right = i;
            while(left-1 >=0 && nums[left] > nums[left-1]) left--;
            while(right+1 < N && nums[right] > nums[right+1]) right++;
            if(right - left + 1 >= 3 && left < i && right > i)
                max = Math.max(right-left+1,max);
        }

        System.out.println(max);
    }
}
