package _02_LeetCode_Solution.Tree.No102;

import java.util.ArrayList;
import java.util.List;

/**
 * 简化代码：Don't repeat yourself
 * 将对于根节点的处理看做是同一般节点的处理一样
 */
class Solution2 {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        Helper(root,0);
        return result;
    }

    public void Helper(TreeNode root,int height){
        if(root == null)
            return;
        if(result.size() <= height)
            result.add(new ArrayList<>());
        result.get(height).add(root.val);
        Helper(root.left,height+1);
        Helper(root.right,height+1);
    }

}
