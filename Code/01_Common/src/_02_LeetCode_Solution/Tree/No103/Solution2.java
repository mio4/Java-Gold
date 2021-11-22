package _02_LeetCode_Solution.Tree.No103;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * TODO 使用两个栈的方式来实现遍历
 * TODO 找个时间手写一下
 * TODO DEBUG NOT FINISHED
 */
class Solution2 {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);
        TreeNode tempNode = null;
        List<Integer> singleList  = new ArrayList<Integer>();
        while(!stack1.empty() || !stack2.empty()){
            while(!stack1.empty()){
                tempNode = stack1.pop();
                if(tempNode != null) {
                    singleList.add(tempNode.val);
                    if (tempNode.left != null)
                        stack2.push(tempNode.left);
                    if (tempNode.right != null)
                        stack2.push(tempNode.right);
                }
            }
            if(!singleList.isEmpty()){
                result.add(singleList);
                singleList = new ArrayList<Integer>();
            }
            while(!stack2.empty()){
                tempNode = stack2.pop();
                if(tempNode != null) {
                    singleList.add(tempNode.val);
                    if (tempNode.left != null)
                        stack1.push(tempNode.right);
                    if (tempNode.right != null)
                        stack1.push(tempNode.left);
                }
            }
            if(!singleList.isEmpty()){
                result.add(singleList);
                singleList = new ArrayList<Integer>();
            }
        }
        return result;
    }

    public static void main(String[] args){
        zigzagLevelOrder(null);
    }
}
