package _02_LeetCode_Solution.Tree.No662;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public static int widthOfBinaryTree(TreeNode root) {
        ArrayList<Integer> start=new ArrayList<>();
        ArrayList<Integer> end=new ArrayList<>();
        return dfs(root,0,1,start,end);
    }

    public static int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end) {
        if (root == null) {
            return 0;
        }
        if (start.size() == level) {
            start.add(order);
            end.add(order);
        }
        end.set(level, order);
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, 2 * order, start, end);
        int right = dfs(root.right, level + 1, 2 * order + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(9);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;
        int width = widthOfBinaryTree(root);
    }
}
