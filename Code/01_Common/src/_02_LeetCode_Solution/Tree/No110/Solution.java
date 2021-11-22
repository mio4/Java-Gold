package _02_LeetCode_Solution.Tree.No110;

/**
 * 110. Balanced Binary Tree
 * 需要记住的一点是：关于二叉树的大部分问题都需要递归遍历才能解决
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
    public static boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        boolean flag = isBalanced(root.left) & isBalanced(root.right);
        int subHeight = getHeight(root.left) - getHeight(root.right);
        if(subHeight >= -1 && subHeight <= 1)
            return flag;
        else
            return false;
    }

    public static int getHeight(TreeNode node){
        if(node == null)
            return 0;
        if(node.left == null && node.right == null)
            return 1;
        return Math.max(getHeight(node.left),getHeight(node.right))+1;
    }
}
