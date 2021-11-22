package _02_LeetCode_Solution.Tree.N226;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }
}

/**
 * 翻转二叉树：
 * （1）在访问对象的成员变量前考虑对象是否是null
 * （2）交换当前树的左右子树（使用临时变量保存引用）
 * （3）对当前树的左右子树做【相同】递归操作
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
