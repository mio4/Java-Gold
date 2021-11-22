package _02_LeetCode_Solution.DFS.No39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  非常经典的一种题型
 */
class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        findTargetSum(result,new ArrayList<Integer>(),candidates,target,0);
        return result;
    }

    public static boolean findTargetSum(List<List<Integer>> result,List<Integer> temp,int[] candidate,int remains,int index){
        if(remains < 0)
            return false;
        else if(remains == 0){
            //result.add(temp);
            result.add(new ArrayList<>(temp));
            return false;
        }
        else{
            for(int i=index; i < candidate.length; i++){
                boolean isFind = false;
                temp.add(candidate[i]);
                isFind = findTargetSum(result,temp,candidate,remains-candidate[i],i);
                temp.remove(temp.size()-1);
                if(!isFind)
                    break;
            }
            return true;
        }
    }

    public static void main(String[] args){
        int[] candidate = {2,3,6,7};
        combinationSum(candidate,7);
    }
}
