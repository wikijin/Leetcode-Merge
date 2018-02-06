	题意： 
		比对两棵二叉树
  
	思路：	 	
	 	同时前序遍历
	 
	复杂度：      
     time : O(n);
     space : O(n);
     
      
class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
	if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    
}
}