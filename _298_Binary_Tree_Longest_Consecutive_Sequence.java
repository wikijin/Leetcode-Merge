package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : BinaryTreeLongestConsecutiveSequence
 * Creator : Edward
 * Description : 298. Binary Tree Longest Consecutive Sequence
 */

public class _298_Binary_Tree_Longest_Consecutive_Sequence {
	/**
     Given a binary tree, find the length of the longest consecutive sequence path.
     The path refers to any sequence of nodes from some starting node to any node
     in the tree along the parent-child connections. The longest consecutive path need to
     be from parent to child (cannot be the reverse).
     For example,
      1
      \
       3
      / \
     2   4
          \
           5
     Longest consecutive sequence path is 3-4-5, so return 3.
        2
         \
         3
        /
       2
      /
     1
     Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 	题意： 
		找出二叉树中从任意节点出发节点值成连续升序排列的路径长度的最大值
		注：路径前进方向只能是从父节点到子节点
  
	 思路：
	 	深度优先搜索（DFS）
	 	使用一个局部变量记录并更新当前路径的长度
	 	使用一个全局变量记录并更新所有路径长度的最大值
	 
	 复杂度：           
     time : O(n);
     space : O(n);
     * @param root
     * @return
     */

    private static int res = 0;

    public static int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0, root.val);
        return res;
    }

    public static void helper(TreeNode root, int max, int target) {
        if (root == null) return;
        if (root.val == target) {
            max++;
        } else max = 1;
        res = Math.max(res, max);
        helper(root.left, max, root.val + 1);
        helper(root.right, max, root.val + 1);
    }

}