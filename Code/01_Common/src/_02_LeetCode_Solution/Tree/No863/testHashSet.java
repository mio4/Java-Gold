package _02_LeetCode_Solution.Tree.No863;

import java.util.HashSet;
import java.util.Set;

public class testHashSet {

    public static void main(String[] args){
        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        if(set.contains(1))
            System.out.println("contains " + set.toString());
        set.add(2);
        System.out.println("contains " + set.toString());
    }

}
