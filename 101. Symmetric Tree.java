	题意： 
		判断一棵二叉树是否左右对称
		注：树的子节点不必也是对称中心
  
	思路：	 	
	 	同时向左右层级遍历并镜像比较
	 
	复杂度：      
     time : O(n);
     space : O(n);
     
      
class Solution {
	public boolean isSymmetric(TreeNode root) {
	if (root == null) return true;
        return helper(root.left, root.right);
    }

    public static boolean helper(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return helper(p.left, q.right) && helper(p.right, q.left);
    }
}