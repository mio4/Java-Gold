package _02_LeetCode_Solution.Tree.No543;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}

/**
 * 思路错了，不能是左边MAX+右边MAX
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        return getMaxDepth(root.left) + getMaxDepth(root.right);

    }

    private int getMaxDepth(TreeNode node){
        if(node == null)
            return 0;
        return Math.max(getMaxDepth(node.left),getMaxDepth(node.right))+1;
    }
}
