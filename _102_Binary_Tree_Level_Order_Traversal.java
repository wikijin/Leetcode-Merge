package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : BinaryTreeLevelOrderTraversal
 * Creator : Edward
 * Description : 102. Binary Tree Level Order Traversal
 */

public class _102_Binary_Tree_Level_Order_Traversal {
	/**
     Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
     For example:
     Given binary tree [3,9,20,null,null,15,7],
          3
         / \
        9  20
      /  \
     15   7
     [
     [3],
     [9,20],
     [15,7]
     ]
 	题意： 
		实现二叉树的层级遍历
  
	 思路：
	 	宽度优先搜索（BFS）；
	 	前序遍历（BFS变体）
	 
	 复杂度：      
     time : O(n);
     space : O(n);
     * @param root
     * @return
     */

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                list.add(cur.val);
            }
            res.add(list);
        }

        return res;
    }

    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root, 0);
        return res;
    }

    public static void helper(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) return;
        if (level >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);
    }
}
