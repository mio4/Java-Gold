package _03_SwordOnOffer.MirrorBinaryTree;

import _03_SwordOnOffer.TreeNode;
import _03_SwordOnOffer.Util;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 判断一颗二叉树是否是对称的
 */
public class Solution {
    public static boolean isSymmetrical(TreeNode pRoot) {
        //1. 得到二叉树的层次遍历结果
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        int start = 0;
        int end = 1; //预计第一层的节点个数
        ArrayList<Integer> tmp = new ArrayList<>();
        queue.add(pRoot);
        while(!queue.isEmpty()){
            TreeNode cur = queue.pop();
            tmp.add(cur.val);
            start++;
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }

            //判断当前层是否打印完成
            if(start == end){
                start = 0;
                end = queue.size(); //队列剩下的元素个数 == 下面一层的元素个数
                res.add(tmp);
                tmp = new ArrayList<>();
            }
        }

        //2.遍历二叉树的层次遍历结果，从左往右==从右往左的遍历结果
        for(int i=0; i < res.size(); i++){
            ArrayList<Integer> t = res.get(i);
            for(int j=0; j <= t.size()/2; j++){
                if(!t.get(j).equals(t.get(t.size()-j-1))){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode node = Util.generateBinaryTree2();
        System.out.println(isSymmetrical(node));
    }
}