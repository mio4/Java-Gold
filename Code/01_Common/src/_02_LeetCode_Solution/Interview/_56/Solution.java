package _02_LeetCode_Solution.Interview._56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]); //升序排列
        int i=0;
        while(i < intervals.length){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while(i+1 < intervals.length && intervals[i+1][0] <= right){
                right = Math.max(right,intervals[i+1][1]);
                i++;
            }
            res.add(new int[]{left,right});
            i++;
        }
        int[][] r = new int[res.size()][2];
        for(int t=0; t < res.size();t++){
            r[t][0] = res.get(t)[0];
            r[t][1] = res.get(t)[1];
        }
        return r;
    }

    public static void main(String[] args) {
//        int[][] num = {{1,4},{4,5}};
        int[][] num = {{4,5},{1,4}};

        merge(num);
    }

    private static void test(int[][] num){
//        Arrays.sort(num,(a,b)-> a[0]-b[0]);
//        Arrays.sort(num,(a,b)-> b[0]-a[0]);
//        System.out.println(Arrays.toString(num));
    }
}
