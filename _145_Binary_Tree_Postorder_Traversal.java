package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : BinaryTreePostorderTraversal
 * Creator : Edward
 * Description : 145. Binary Tree Postorder Traversal
 */

public class _145_Binary_Tree_Postorder_Traversal {
	/**
      Given a binary tree, return the postorder traversal of its nodes' values.

		For example:
		Given binary tree [1,null,2,3],
		
		   1
		    \
		     2
		    /
		   3
		 
		
		return [3,2,1].
		
		Note: Recursive solution is trivial, could you do it iteratively?
		
	题意： 
		实现二叉树的后序遍历
     

	 思路：
	 	递归与非递归（迭代）
	 
	 复杂度：      
      time : O(n);
      space : O(n);
      @param root
      @return
     */
	public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }
    public static void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        helper(res, root.left);
        helper(res, root.right);
        res.add(root.val);
    }

    public static List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.addFirst(cur.val);
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        return res;
    }
}
