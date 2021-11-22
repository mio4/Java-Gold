package _02_LeetCode_Solution.Tree.No94;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
class Solution {
    private List<Integer> result = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root != null) {
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
        }
        return result;
    }
}
