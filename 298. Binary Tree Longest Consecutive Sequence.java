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
     
      
class Solution {
	private int res = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0, root.val);
        return res;
    }

    public void helper(TreeNode root, int max, int target) {
        if (root == null) return;
        if (root.val == target) {
            max++;
        } else max = 1;
        res = Math.max(res, max);
        helper(root.left, max, root.val + 1);
        helper(root.right, max, root.val + 1);
    }

}