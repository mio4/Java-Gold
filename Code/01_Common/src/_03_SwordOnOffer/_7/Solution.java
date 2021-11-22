package _03_SwordOnOffer._7;

import _03_SwordOnOffer.TreeNode;

/**
 * TODO 修复bug
 */
public class Solution {
    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        return helper(pre,0,pre.length-1,in,0,in.length-1);
    }

    private static TreeNode helper(int[] pre, int b1,int e1, int[] in, int b2,int e2){
        TreeNode root = new TreeNode(pre[b1]);
        int middle = -1;
        for(int i=b1; i < e1; i++){
            if(in[i] == pre[b1]){
                middle = i;
                break;
            }
        }
        int len1 = middle - b1;
        int len2 = e2 - middle;
        if(middle-1 >= b2)
            root.left = helper(pre,b1+1,b1+len1,in,b2,middle-1);
        if(e2 >= middle+1)
            root.right = helper(pre,b1+len1+1,e1,in,middle+1,e2);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in  = {4,7,2,1,5,3,8,6};

        reConstructBinaryTree(pre,in);
    }
}
