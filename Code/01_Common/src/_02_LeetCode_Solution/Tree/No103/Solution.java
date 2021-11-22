package _02_LeetCode_Solution.Tree.No103;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * 蛇形遍历二叉树
 * 就是在102题的基础上修改了一下，不过暴露出了很多问题，比如对于List的使用不够熟悉
 */

import java.util.LinkedList;
import java.util.List;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    private List<List<Integer>> list = new LinkedList<List<Integer>>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        recursion(root,0);
        return list;
    }

    public void recursion(TreeNode node,int level){
        if(node == null)
            return;
        if(list.size() <= level)
            list.add(new LinkedList<Integer>());
        if(level%2 == 0)
            list.get(level).add(node.val);
        else
            ((LinkedList)list.get(level)).addFirst(node.val);
        recursion(node.left,level+1);
        recursion(node.right,level+1);
    }
}
