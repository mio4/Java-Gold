package _02_LeetCode_Solution.Tree.No437;

import java.util.Arrays;

/**
 * static方法会影响judge-machine的判断
 * 1. 每一层都需要开辟新的数据 空间，并且涉及到数组的拷贝；递归调用函数消耗时间，所以效率不高
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
public class PathSumIII {
    private static int result = 0;
    public static int pathSum(TreeNode root, int sum) {
        if(root == null){
            return result;
        }
        int[] first_cache = new int[0];
        recursion(1,root,first_cache,sum);
        return result;
    }

    private static void recursion(int height,TreeNode root,int[] cache,int sum){
        int[] new_cache = new int[height];
        new_cache[0] = root.val;
        for(int i=0; i < cache.length; i++){
            new_cache[i+1] = cache[i] + root.val;
        }
        for(int i=0; i < new_cache.length; i++){
            if(new_cache[i] == sum){
                result++;
            }
        }
        if(root.left != null){
            recursion(height+1,root.left, Arrays.copyOf(new_cache,new_cache.length),sum);
        }
        if(root.right != null){
            recursion(height+1,root.right, Arrays.copyOf(new_cache,new_cache.length),sum);
        }
    }

    public static void main(String[] args){
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(4);
        TreeNode a3 = new TreeNode(8);
        TreeNode a4 = new TreeNode(11);
        TreeNode a5 = new TreeNode(13);
        TreeNode a6 = new TreeNode(4);
        TreeNode a7 = new TreeNode(7);
        TreeNode a8 = new TreeNode(2);
        TreeNode a9 = new TreeNode(5);
        TreeNode a10 = new TreeNode(1);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a3.left = a5;
        a3.right = a6;
        a4.left = a7;
        a4.right = a8;
        a5.left = a9;
        a5.right = a10;


        int ans = pathSum(a1,22);
    }
}
