package _02_LeetCode_Solution.Tree.No199;

import java.util.ArrayList;
import java.util.List;


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {
    public static List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root != null)
            recursion(result,0,root);
        List<Integer> view = new ArrayList<Integer>();
        for(List<Integer> a : result){
            view.add(a.get(a.size()-1));
        }
        return view;
    }

    public static void recursion(List<List<Integer>> result,int height, TreeNode node){
        if(height >= result.size())
            result.add(new ArrayList<Integer>());
        result.get(height).add(node.val);
        if(node.left != null)
            recursion(result,height+1,node.left);
        if(node.right != null)
            recursion(result,height+1,node.right);
    }
}
