package _02_LeetCode_Solution.Tree.No114;

/**
 * 只能通过直接改变root节点来实现【弃】
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
    private static TreeNode dummy = new TreeNode(-1);
    private static TreeNode temp = dummy;
    public static void flatten(TreeNode root) {
        recursion(root);
        root = dummy.right;
        TreeNode t = root;
    }

    public static void recursion(TreeNode node){
        if(node == null)
            return;
        temp.left = null;
        temp.right = new TreeNode(node.val);
        temp = temp.right;
        recursion(node.left);
        recursion(node.right);
    }

}
