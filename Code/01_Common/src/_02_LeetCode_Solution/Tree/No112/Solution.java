package _02_LeetCode_Solution.Tree.No112;

import _03_SwordOnOffer.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static boolean hasPathSum(TreeNode root, int sum) {
        //递归终止条件
        if(root == null){
            return false;
        }
//        if(root.val > sum){
//            return false;
//        }
        if(root.left == null && root.right == null && root.val == sum){
            return true;
        }

        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(-2);
        TreeNode t2 = new TreeNode(-3);
        t1.right = t2;
        hasPathSum(t1,-5);
    }
}
