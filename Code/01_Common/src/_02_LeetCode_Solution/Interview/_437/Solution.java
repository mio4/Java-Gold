package _02_LeetCode_Solution.Interview._437;

import _02_LeetCode_Solution.Interview.TreeNode;
import _02_LeetCode_Solution.Interview.getTree;

public class Solution {
    public static int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return helper(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }

    private static int helper(TreeNode root, int sum){
        if(root == null) return 0;
        sum -= root.val;
        return (sum == 0 ? 1 : 0) + helper(root.left,sum) + helper(root.right,sum);
    }

    public static void main(String[] args) {
        TreeNode root = getTree.get1();
        System.out.println(pathSum(root,3));
    }
}
