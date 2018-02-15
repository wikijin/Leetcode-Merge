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
     time : O(n);
     space : O(n);
     
      
class Solution {
    public int sumNumbers(TreeNode root) {
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