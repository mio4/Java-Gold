package _02_LeetCode_Solution.DFS.No40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 就是一个DFS深搜
 * 这种问题最开始看起来很麻烦
 * 其实就是对数组排序之后进行递归处理，需要注意的是递归结束的条件以及对于list的处理
 */
class Solution2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); //排序之后的比较能够简化【后面的一部分】
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        DFS(result,new ArrayList<>(),candidates,target,0);
        return result;
    }

    public static boolean DFS(List<List<Integer>> result,List<Integer> temp,int[] candidates,int remains,int index){
        if(remains < 0)
            return false;
        else if(remains == 0){
            if(!result.contains(new ArrayList<Integer>(temp)))
                result.add(new ArrayList<Integer>(temp));
            return false;
        }
        else{
            for(int i=index;i < candidates.length; i++){
                boolean isFind;
                temp.add(candidates[i]);
                isFind = DFS(result,temp,candidates,remains-candidates[i],i+1);
                temp.remove(temp.size()-1);
                if(!isFind) //当前层后面的情况都不用考虑了，肯定是sum大于remains的情况
                    break;
            }
            return true;
        }
    }
    public static void main(String[] args){
        int[] arr = {10,1,7,6,1,2,5};
        List<List<Integer>> list = combinationSum2(arr,8);
        System.out.println(list);
    }
}
