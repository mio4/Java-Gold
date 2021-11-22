package _02_LeetCode_Solution.Tree.No124;

/**
 * 124. Binary Tree Maximum Path Sum
 * （1）在研究最值问题的时候，最新是处于一个待更新的状态，而不是要说一次性把最值找出来
 * （2）这种问题很适用DFS
 * （3）在看待树时，需要将树看做根节点+左子树+右子树的整体，对于叶子节点也是这样
 * （4）递归问题一般在叶子节点时结束递归
 * （5）从一般的demo分析，找到其中的规律
 *
 * 对于任意一棵树，把它看做是一颗子树，所以左右节点只能选择一个
 * 但是对于result的更新，需要将左右节点和当前节点的值加起来看做是一颗完整的树
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
class Solution {
    private int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        Helper(root);
        return result;
    }

    public int Helper(TreeNode node){
        if(node == null) //如果是空节点，值默认是0
            return 0;
        int left_val = Math.max(Helper(node.left),0);
        int right_val = Math.max(Helper(node.right),0);
        result = Math.max(result,left_val+right_val+node.val);
        return Math.max(left_val,right_val)+node.val;
    }
}
