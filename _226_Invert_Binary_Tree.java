package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : InvertBinaryTree
 * Creator : Edward
 * Description : 226. Invert Binary Tree
 */

public class _226_Invert_Binary_Tree {
    /**
     Invert a binary tree.
          4
        /   \
       2     7
      / \   / \
     1   3 6   9
     to
         4
        /   \
       7     2
      / \   / \
     9   6 3   1
     
 	题意： 
		实现二叉树的镜像翻转
  
	 思路：
	 	宽度优先搜索（BFS）；
	 	前序遍历（DFS）
	 
	 复杂度：      
     time : O(n)
     space : O(n);
     * @param root
     * @return
     */

    public static TreeNode invertTree(TreeNode root) {
       if (root == null) return root;
       TreeNode left = invertTree(root.left);
       TreeNode right = invertTree(root.right);
       root.left = right;
       root.right = left;
       return root;
    }

    public static TreeNode invertTree2(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);
        }
        return root;
    }
}