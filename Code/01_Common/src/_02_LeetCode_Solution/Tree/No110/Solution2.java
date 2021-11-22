package _02_LeetCode_Solution.Tree.No110;

/**
 * 自顶向下遍历
 * 1.如果节点是空节点，可以看看成一颗平衡二叉树，直接返回true
 * 2.如果左右子树的深度差大于1，直接返回false
 * 3.否则返回左子树和右子树综合判定的结果
 */
class Solution2 {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        if(Math.abs(getDepth(root.left)-getDepth(root.right)) > 1)
            return false;
        return isBalanced(root.left) & isBalanced(root.right);
    }

    public static int getDepth(TreeNode node){
        if(node == null)
            return 0;
        return Math.max(getDepth(node.left),getDepth(node.right))+1;
    }
}
