package Interview2020._360._2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] num1 = new int[n];
        int[] num2 = new int[n];
        for(int i=0; i < n; i++){
            num1[i] = sc.nextInt();
        }
        for(int i=0; i < n; i++){
            num2[i] = sc.nextInt();
        }

        int[] used1 = new int[n];
        int[] used2 = new int[n];
        int[] res = new int[n];
        int count = 0;
        while(count < n){
            //1.找到最接近m-1的值
            int sum = 0;
            int n1 = 0;
            int n2 = 0;
            for(int i=0; i < n; i++){
                for(int j=0; j < n; j++){
                    int cur = (num1[i]+num2[j])%m;
                    if(used1[i] == 0 && used2[j] == 0 && cur >= sum ){
                        n1 = num1[i];
                        n2 = num2[j];
                        sum = cur;
                    }
                }
            }
            //2. 标记那两个值
            for(int i=0; i < n; i++){
                if(num1[i] == n1){
                    used1[i] = 1;
                    break;
                }
            }
            for(int j=0; j < m; j++){
                if(num2[j] == n2){
                    used2[j] = 1;
                    break;
                }
            }

            //3. 更新count和res
            res[count] = (n1+n2)%m;
            count++;
        }


        //输出结果
        for(int i=0; i < n-1; i++){
            System.out.print(res[i] + " ");
        }
        System.out.print(res[n-1]);
    }
}
