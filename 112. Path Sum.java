	 题意： 
		查询某个值是否等于从根节点到任一叶子节点的路径的和
  
	 思路：
	 	深度优先搜索（DFS）的两种实现，递归与迭代
	 
	 复杂度：   
     time : O(n);
     space : O(n);
     
      
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.left == null && cur.right == null) {
                if (cur.val == sum) {
                    return true;
                }
            }
            if (cur.right != null) {
                stack.push(cur.right);
                cur.right.val += cur.val;
            }
            if (cur.left != null) {
                stack.push(cur.left);
                cur.left.val += cur.val;
            }
        }
        return false;
    }
}