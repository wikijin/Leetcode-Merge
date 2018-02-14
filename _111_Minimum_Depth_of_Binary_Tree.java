package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : MinimumDepthofBinaryTree
 * Creator : Edward
 * Description : 111. Minimum Depth of Binary Tree
 */

public class _111_Minimum_Depth_of_Binary_Tree {
	/**
     Given a binary tree, find its minimum depth.
     The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 	题意： 
		找出二叉树最短的深度
  
	 思路：
	 	深度优先搜索（DFS），递归
	 	宽度优先搜索（BFS），层级遍历的变种
	 		 
	 复杂度：    
     time : O(n);
     space : O(n);
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null || root.right == null) {
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
    
    public static int minDepth2(TreeNode root) {
        if (root == null) return 0;
        
        int depth = 1;
        boolean foundLeaf = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                	foundLeaf = true;
                	break;
                }
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);                
            }
            if (foundLeaf) break; 
            depth++;
        }

        return depth;
    }
}