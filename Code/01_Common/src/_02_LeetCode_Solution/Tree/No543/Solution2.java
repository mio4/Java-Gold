package _02_LeetCode_Solution.Tree.No543;

class Solution2 {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }

    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        diameter = Math.max(diameter,left+right);
        return 1+Math.max(left,right);
    }
}