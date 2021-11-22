package _02_LeetCode_Solution.DFS.No40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO fix the bug
 * WARNING not right version
 */
class Solution {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        for(int i=0; i < candidates.length && candidates[i] <= target; i++){
            List<Integer> tmp = new ArrayList<Integer>();
            int sum = 0;
            int j = i;
            while(j < candidates.length){
                sum += candidates[j];
                tmp.add(candidates[j]);
                if(sum < target){ //不满足

                } else if(sum == target){ //满足条件
                    result.add(tmp);
                    sum-=tmp.get(tmp.size()-1);
                    tmp.remove(tmp.size()-1);
                    j--;
                    tmp = new ArrayList<Integer>();
                } else if(sum > target){ //回溯
                    sum -= tmp.get(tmp.size()-1);
                    tmp.remove(tmp.size()-1); //remove last one
                    if(!tmp.isEmpty()) {
                        sum -= tmp.get(tmp.size()-1);
                        tmp.remove(tmp.size() - 1); //remove last two
                    }
                    else  //candidates = [10] target=1
                        return result;
                    j--;
                }
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] a = {10,1,2,7,6,1,5};
        List<List<Integer>> result = combinationSum2(a,8);
        System.out.println(result);
    }
}