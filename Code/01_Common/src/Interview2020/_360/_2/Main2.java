//package Interview2020._360._2;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main2 {
//    private static int[] maxNum;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[] num1 = new int[n];
//        int[] num2 = new int[n];
//        for(int i=0; i < n; i++){
//            num1[i] = sc.nextInt();
//        }
//        for(int i=0; i < n; i++){
//            num2[i] = sc.nextInt();
//        }
//        maxNum = new int[n];
//        Arrays.fill(maxNum,-1);
//
//        permutation(num1,num2,n,m,0);
//        System.out.println(Arrays.toString(maxNum));
//    }
//
//    private static void permutation(int[] num1,int[] num2,int n,int m,int beginIndex){
//        if(beginIndex == n-1){
//            boolean isLarger = false;
//            for(int i=0; i < n;i++){
//                int cur = (num1[i]+num2[i])%m;
//                if(maxNum[i] == -1) maxNum[i] = cur;
//                else{
//                    if(cur > maxNum[i]){
//                        isLarger = true;
//                        break;
//                    }
//                    else if(cur == maxNum[i]){
//                        continue;
//                    }
//                    else{
//                        break;
//                    }
//                }
//            }
//            if(isLarger){
//                for(int i=0; i < n; i++){
//                    maxNum[i] = (num1[i]+num2[i])%m;
//                }
//            }
//            return;
//        }
//        for(int curIndex = beginIndex; curIndex < n; curIndex++){
//            swap(num2,beginIndex,curIndex);
//            permutation(num1,num2,n,m,beginIndex+1);
//            swap(num2,beginIndex,curIndex);
//        }
//    }
//
//    private static void swap(int[] num,int i,int j){
//        int temp = num[i];
//        num[i] = num[j];
//        num[j] = temp;
//    }
//}
