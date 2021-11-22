package _02_LeetCode_Solution.Tree.No110;

/**
 * TODO 优化时间复杂度
 */
class Solution3 {
    private boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        if(!balanced)
            return false;
        if(root == null)
            return true;
        if(Math.abs(getDepth(root.left)-getDepth(root.right)) > 1) {
            balanced = false;
            return false;
        }
        return isBalanced(root.left) & isBalanced(root.right);
    }

    public static int getDepth(TreeNode node){
        if(node == null)
            return 0;
        return Math.max(getDepth(node.left),getDepth(node.right))+1;
    }
}
