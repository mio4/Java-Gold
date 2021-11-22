package _02_LeetCode_Solution.Interview._662;

import _02_LeetCode_Solution.Interview.TreeNode;
import _02_LeetCode_Solution.Interview.getTree;

import java.util.ArrayList;
import java.util.List;

class Node{
    public Integer min = null;
    public Integer max = null;
    public Node(){}
}
class Solution {
    private static List<Node> list = new ArrayList<>();
    private static int max = 0;
    public static int widthOfBinaryTree(TreeNode root) {
        InOrder(root,0,0);
        helper();
        return max;
    }

    private static void helper(){
        for(int i=0; i < list.size(); i++){
            Node t = list.get(i);
            if(t.min != null && t.max != null){
                max = Math.max(max,t.max-t.min);
            }
        }
    }

    private static void InOrder(TreeNode root,int height,int width){
        if(root != null){

            if(height >= list.size()){
                list.add(new Node());
            }
            if(list.get(height).min == null)
                list.get(height).min = width;
            else
                list.get(height).min = Math.min(list.get(height).min,width);
            if(list.get(height).max == null)
                list.get(height).max = width;
            else
                list.get(height).max = Math.max(list.get(height).max,width);

            InOrder(root.left,height+1,width-1);
            InOrder(root.right,height+1,width+1);
        }
    }

    public static void main(String[] args) {
//        TreeNode root = getTree.get2();
        TreeNode root = getTree.get3();
        System.out.println(widthOfBinaryTree(root));
    }
}
