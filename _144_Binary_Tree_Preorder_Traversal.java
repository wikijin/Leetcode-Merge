package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : BinaryTreePreorderTraversal
 * Creator : Edward
 * Description : 144. Binary Tree Preorder Traversal
 */
public class _144_Binary_Tree_Preorder_Traversal {

    /**
     Given a binary tree, return the preorder traversal of its nodes' values.
     For example:
     Given binary tree {1,#,2,3},
     1
      \
      2
      /
     3
     return [1,2,3].
     
      题意： 
      	实现二叉树的前序遍历
     

     思路：
     	递归与非递归（迭代）
     
     复杂度：
     time : O(n);
     space : O(n);
     * @param root
     * @return
     */

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }

    public static void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);
    }

    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
            res.add(cur.val);
        }
        return res;
    }
}