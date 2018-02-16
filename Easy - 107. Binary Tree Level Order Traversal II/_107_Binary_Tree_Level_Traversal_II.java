package leetcode;

import java.util.*;
/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : BinaryTreeLevelOrderTreaversalII
 * Creator : Edward
 * Date : Sep, 2017
 * Description : 107. Binary Tree Level Order Traversal II  (102 follow up)
 */
public class BinaryTreeLevelOrderTraversalII {

    /**
     *
     * @param root
     * @return
     */

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            res.add(0, list);
        }
        return res;
    }

    public static List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root, 0);
        return res;
    }

    public static void helper(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) return;
        if (level >= res.size()) {
            res.add(0, new ArrayList<>());
        }
        res.get(res.size() - level - 1).add(root.val);
        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);

    }

}