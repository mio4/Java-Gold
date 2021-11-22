package _02_LeetCode_Solution.Tree.No102;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. Binary Tree Level Order Traversal
 * （1）使用前序遍历
 * （2）每增加一层递归，树的高度增加一层
 * （3）List<List<Integer>>get时注意下标不能违法
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
class Solution {
    //TODO 初始化list
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return result;
        result.add(new ArrayList<>());
        result.get(0).add(root.val);
        inorderTraversal(root.left,1);
        inorderTraversal(root.right,1);
        return result;
    }

    public void inorderTraversal(TreeNode node, int height){
        if(node == null)
            return;
        if(result.size() <= height)
            result.add(new ArrayList<>());
        result.get(height).add(node.val);
        inorderTraversal(node.left,height+1);
        inorderTraversal(node.right,height+1);
    }
}
