package _02_LeetCode_Solution.Permutation.No17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        int len = digits.length();
        if(len == 1){
            return NumToLetter(digits.charAt(0));
        }
        else {
            List<String> res = new ArrayList<>();
            List<String> part1 = NumToLetter(digits.charAt(0));
            List<String> part2 = letterCombinations(digits.substring(1,len));
            for(int i=0; i < part1.size(); i++){
                for(int j=0; j < part2.size(); j++){
                    res.add(part1.get(i) + part2.get(j));
                }
            }
            return res;
        }
    }

    private static List<String> NumToLetter(char num){
        if(num == '2')
            return Arrays.asList("a","b","c");
        else if(num == '3')
            return Arrays.asList("d","e","f");
        else if(num == '4')
            return Arrays.asList("g","h","i");
        else if(num == '5')
            return Arrays.asList("j","k","l");
        else if(num == '6')
            return Arrays.asList("m","n","o");
        else if(num == '7')
            return Arrays.asList("p","q","r","s");
        else if(num == '8')
            return Arrays.asList("t","u","v");
        else if(num == '9')
            return Arrays.asList("w","x","y","z");
        else
            return Arrays.asList("");
    }

    public static void main(String[] args) {
        List<String> res = letterCombinations("23");
        System.out.println(res);
        List<String> res2 = letterCombinations("234");
        System.out.println(res2);
    }
}
