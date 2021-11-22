package _02_LeetCode_Solution.Tree.No662;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 理解这种解题的思路和方法
 */
public class Solution3 {
    public static int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
    }

    public static int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end){
        if(root == null)return 0;
        if(start.size() == level){
            start.add(order); end.add(order);
        }
        else end.set(level, order);
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, 2*order, start, end);
        int right = dfs(root.right, level + 1, 2*order + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }
}
