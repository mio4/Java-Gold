package _03_SwordOnOffer.PrintBinaryTree;

import _03_SwordOnOffer.TreeNode;
import _03_SwordOnOffer.Util;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 层次打印二叉树
 * （1）深度优先搜索：
 *
 * （2）广度优先搜索：
 *      （1）将节点加入到队列中，
 *      （2）如果队列不为空，弹出队列元素，将元素的左子树和右子树加入到队列中
 *      （3）难点：如果将同一层的节点添加到同一个ArrayList中
 *          记录当前层的个数
 *          如果当前层已经打印完成——弹出的节点个数==预计本层的节点个数
 */
public class Solution {
    public static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null){
            return res;
        }
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
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = Util.generateBinaryTree();
        Print(root);
    }

}
