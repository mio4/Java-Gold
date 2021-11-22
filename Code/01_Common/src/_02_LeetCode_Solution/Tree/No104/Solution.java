package _02_LeetCode_Solution.Tree.No104;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    private int max_depth = 0;
    public int maxDepth(TreeNode root) {
        Helper(root,1);
        return max_depth;
    }

    private void Helper(TreeNode node, int depth){
        if(node == null){
            return;
        }

        if(max_depth < depth){
            max_depth = depth;
        }

        if(node.left != null){
            Helper(node.left,depth+1);
        }
        if(node.right != null){
            Helper(node.right,depth+1);
        }
    }
}
