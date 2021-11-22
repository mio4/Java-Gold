package _02_LeetCode_Solution.Interview._7;

public class Solution {



    public static void main(String[] args) {
        String s = "2147483648";
        try{
            Integer i = Integer.parseInt(s);
        } catch (Exception e){
            System.out.println("?");
            System.out.println(e);
        }
    }
}
