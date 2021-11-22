package _02_LeetCode_Solution.Tree.No617;

/**
 * 617. Merge Two Binary Trees
 * 分情况讨论：
 * 以节点t1为基准点
 * （1）如果两个节点为空，没有必要合并
 * （2）如果其中一个节点为空，直接返回不为空的节点
 * （3）如果两个节点都不为空，值相加后，递归处理两个节点的左右子树
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null && t2==null)
            return t1;
        else if(t1!=null && t2==null){
            return t1;
        }
        else if(t1==null && t2!=null){
            return t2;
        }
        else if(t1!=null && t2!=null){
            t1.val += t2.val;
            t1.left =  mergeTrees(t1.left,t2.left);
            t1.right = mergeTrees(t1.right,t2.right);
            return t1;
        }
        return t1;
    }
}
