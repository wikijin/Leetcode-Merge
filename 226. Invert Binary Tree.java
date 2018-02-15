	 题意： 
		实现二叉树的镜像翻转
  
	 思路：
	 	宽度优先搜索（BFS）；
	 	前序遍历（DFS）
	 
	 复杂度：            
     time : O(n);
     space : O(n);
     
      
class Solution {
	
	public TreeNode invertTree(TreeNode root) {
       if (root == null) return root;
       TreeNode left = invertTree(root.left);
       TreeNode right = invertTree(root.right);
       root.left = right;
       root.right = left;
       return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);
        }
        return root;
    }
}