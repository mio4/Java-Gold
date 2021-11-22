package _03_SwordOnOffer.MirrorBinaryTree;

import _03_SwordOnOffer.TreeNode;
import _03_SwordOnOffer.Util;

public class Solution2 {
    public static boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null){
            return true;
        }
        return helper(pRoot.left,pRoot.right);
    }

    public static boolean helper(TreeNode left,TreeNode right){
        //递归终止条件
        if(left == null && right == null){
            return true;
        }
        if(left == null && right != null){
            return false;
        }
        if(left != null && right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        //递归
        return helper(left.left, right.right) && helper(left.right,right.left);
    }

    public static void main(String[] args) {
        TreeNode node = Util.generateBinaryTree2();
        System.out.println(isSymmetrical(node));
    }
}
