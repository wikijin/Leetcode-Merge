package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : PathSumII
 * Creator : Edward
 * Description : 113. Path Sum II
 */

public class _113_Path_Sum_II {
	/**
     Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
     For example:
     Given the below binary tree and sum = 22,
           5
          / \
         4   8
        /   / \
       11  13  4
      /  \    / \
     7    2  5   1
     [
     [5,4,11,2],
     [5,8,4,5]
     ]
 	题意： 
		给出一个二叉树和一个sum值，找出所有从根节点到叶子节点的路径，这些路径需要满足：路径上所有节点的和=sum
  
	 思路：
	 	深度优先搜索（DFS），递归
	 
	 复杂度： 
     time : O(n);
     space : O(n);
     * @param root
     * @param sum
     * @return
     */
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, new ArrayList<>(), root, sum);
        return res;
    }
    public static void helper(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                res.add(new ArrayList<>(list));
            }
        }
        helper(res, list, root.left, sum - root.val);
        helper(res, list, root.right, sum - root.val);
        list.remove(list.size() - 1);
    }
}