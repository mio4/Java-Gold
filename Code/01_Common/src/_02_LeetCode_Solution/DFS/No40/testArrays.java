package _02_LeetCode_Solution.DFS.No40;

import java.util.ArrayList;
import java.util.List;

public class testArrays {

    public static void main(String[] args){
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        l1.add(10);
        l1.add(20);
        l1.add(30);
        l2.add(10);
        l2.add(20);
        l2.add(30);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(new ArrayList<>(l1));
        if(list.contains(new ArrayList<>(l2)))
            System.out.println("contains ");
    }
}
