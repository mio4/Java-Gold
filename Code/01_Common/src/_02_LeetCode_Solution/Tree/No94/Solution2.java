package _02_LeetCode_Solution.Tree.No94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 维护一个栈来保存根节点的左子树节点
 * 很巧妙的设计
 */
class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur!=null || !stack.empty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}
