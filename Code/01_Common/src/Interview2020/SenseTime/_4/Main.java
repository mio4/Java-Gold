package Interview2020.SenseTime._4;

import java.util.*;

public class Main {
    private static int res = 0;
    private static Set<String> set = new HashSet<>();
    private static Set<Integer> sqrt = new HashSet<>();

    private static List<List<Integer>> used = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        if(n == 1){
            System.out.println(res);
            return;
        }
        calculate();
        permutation(nums,0);
        System.out.println(res);
    }

    private static void calculate(){
        for(int i=0; i <= 100; i++){
            sqrt.add(i*i);
        }
    }

    private static boolean isValid(int[] nums){
        for(int i=0; i < nums.length-1; i++){
            if(!sqrt.contains(nums[i]+nums[i+1]))
                return false;
        }
        return true;
    }

    private static void permutation(int[] nums,int beginIndex){
        if(beginIndex == nums.length){
            String s = "";
            for(int i=0; i < nums.length; i++){
                s += String.valueOf(nums[i]);
            }
            if(!set.contains(s)){
                set.add(s);
                if(isValid(nums)){
                    res++;
                }
            }

//            boolean isSame = false;
//            for(int i=0; i < used.size(); i++){
//                List<Integer> t = used.get(i);
//                isSame = true;
//                for(int j=0; j < t.size(); j++){
//                    if(t.get(j) != nums[j]){
//                        isSame = false;
//                        break;
//                    }
//                }
//                if(isSame) break;
//            }
//            if(!isSame){
//                if(isValid(nums)) res++;
//            }
//            List<Integer> tt = new ArrayList<>();
//            for(int i=0; i < nums.length; i++) tt.add(nums[i]);
//            used.add(tt);
        }

        for(int curIndex=beginIndex; curIndex < nums.length; curIndex++){
            swap(nums,curIndex,beginIndex);
            permutation(nums,beginIndex+1);
            swap(nums,curIndex,beginIndex);
        }

    }

    private static void swap(int[] nums,int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
