package _03_SwordOnOffer.PrintBinaryTreeByZ;

import _03_SwordOnOffer.TreeNode;
import _03_SwordOnOffer.Util;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 层次遍历二叉树=>按之字形遍历二叉树
 *
 */
public class Solution {
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        int start = 0;
        int end = 1; //预计第一层的节点个数
        ArrayList<Integer> tmp = new ArrayList<>();
        queue.add(pRoot);
        boolean flag = true;
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
                if(flag){
                    res.add(tmp);
                }
                else{
                    ArrayList<Integer> tmp_z = new ArrayList<>();
                    for(int i=tmp.size()-1; i >= 0;i--){
                        tmp_z.add(tmp.get(i));
                    }
                    res.add(tmp_z);
                }
                flag = !flag;
                tmp = new ArrayList<>();
            }
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode root = Util.generateBinaryTree();
        Print(root);
    }

}
