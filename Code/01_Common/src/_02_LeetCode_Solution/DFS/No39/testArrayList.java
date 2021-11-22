package _02_LeetCode_Solution.DFS.No39;

import java.util.ArrayList;
import java.util.List;

public class testArrayList {

    public static void main(String[] args){
        List<Integer> son = new ArrayList<Integer>();
        List<List<Integer>> father = new ArrayList<List<Integer>>();
        son.add(1);
        son.add(2);
        father.add(son);
        System.out.println(father);
        son.remove(son.size()-1);
        System.out.println(father);
    }
}
