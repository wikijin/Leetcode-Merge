package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : BinaryTreePaths
 * Creator : Edward
 * Description : 257. Binary Tree Paths
 */

public class _257_Binary_Tree_Paths {
	/**
     Given a binary tree, return all root-to-leaf paths.
     For example, given the following binary tree:
          3
         / \
        9  20
      /  \
     15   7
     ["3->9->15", "3->9->7", "3->20]
     case :
           3
          / \
         9  20
       /  \
     15   7
     3->9->15
     3->9->7
     3->20
     ["3->9->15", "3->9->7", "3->20]
 	题意： 
		打印所有从根节点到任一叶子节点的路径
  
	 思路：
	 	深度优先搜索（DFS）
	 
	 复杂度：           
     time : O(n);
     space : O(n);
     * @param root
     * @return
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root, "");
        return res;
    }
    public static void helper(List<String> res, TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
        }
        if (root.left != null) {
            helper(res, root.left, path + root.val + "->");
        }
        if (root.right != null) {
            helper(res, root.right, path + root.val + "->");
        }
    }
}