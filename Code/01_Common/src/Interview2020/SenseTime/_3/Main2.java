//package Interview2020.SenseTime._3;
//
//import java.util.Scanner;
//
//public class Main2 {
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        int year = sc.nextInt();
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int c = sc.nextInt();
//        int ini = sc.nextInt();
//
//        int part1 = ini;
//        int part2 = 0;
//        int part3 = 0;
//        for(int i=1; i <= year; i++){
//            int t = part1;
//            part1 = a*part1 + b*part2 + c*part3 + (2*i*i-i+32767);
//            part3 = part2;
//            part2 = t;
//        }
//
//        System.out.println(part1);
//    }
//}
