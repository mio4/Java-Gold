package _02_LeetCode_Solution.Tree.No662;

/**
 * test case 96/108
 * 不能依靠循环解决问题
 * 【Give Up】
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    private int maxLen = 1;
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return maxLen;
        TreeNode left = root;
        TreeNode right = root;
        while(!(left.left == null && left.right == null) && !( right.left == null && right.right == null)){
            int path1=0,path2=0;
            if(left.left != null) {
                left = left.left;
                path1 = 0;
            }
            else if(left.right != null){
                left = left.right;
                path1 = 1;
            }

            if(right.right != null){
                right = right.right;
                path2 = 0;
            }
            else if(right.left != null){
                right = right.left;
                path2 = 1;
            }
            int curLen = maxLen*2 - path1 - path2;
            maxLen = curLen > maxLen ? curLen : maxLen;
        }
        return maxLen;
    }


}
