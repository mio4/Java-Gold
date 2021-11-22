package _02_LeetCode_Solution.Tree.No114;

/**
 * 递归实现
 * 主要是对于Java中的引用的概念要搞清楚
 * root.left = node, root.left = null 并不是将node设置为null而是将root.left的指向从node改变为null，这时node并不会变成null
 */
class Solution2 {
    public static void flatten(TreeNode root) {
        if (root == null) return; //这是一个中序遍历的过程
        if (root.left != null) flatten(root.left);  //
        if (root.right != null) flatten(root.right); //
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) root = root.right;
        root.right = temp;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        root.left = n1;
        root.right = n4;
        n1.left = n2;
        n1.right = n3;
        n4.right = n5;
        flatten(root);
        TreeNode t = root;
    }
}
