package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : SumRoottoLeafNumbers
 * Creator : Edward
 * Description : 129. Sum Root to Leaf Numbers
 */

public class _129_Sum_Root_to_Leaf_Numbers {
	/**
     Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
     An example is the root-to-leaf path 1->2->3 which represents the number 123.
     Find the total sum of all root-to-leaf numbers. For example,
       1
      / \
     2   3
     The root-to-leaf path 1->2 represents the number 12.
     The root-to-leaf path 1->3 represents the number 13.
     Return the sum = 12 + 13 = 25.
 	题意：
 		 给定一个节点取值只包含数字0-9的二叉树，每条根节点至叶子节点的路径都可以表示一个数字。
		例如，根至叶子路径1->2->3表示数字123。
		求所有根至叶子数字的和。
		例如，
		    1
		  /   \
		2      3
		根至叶子路径1->2表示数字12
		根至叶子路径1->3表示数字13
		
		返回值sum=12+13=25
		
	思路：
	 	深度优先搜索（DFS），递归。每层递归需要进位（*10）
	 
	 复杂度： 
     time : O(n)
     space : O(n)

     * @param root
     * @return
     */

    public static int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public static int helper(TreeNode root, int num) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return num * 10 + root.val;
        }
        return helper(root.left, num * 10 + root.val) +
                helper(root.right, num * 10 + root.val);
    }
}
