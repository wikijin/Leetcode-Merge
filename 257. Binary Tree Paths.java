	 题意： 
		打印所有从根节点到任一叶子节点的路径
  
	 思路：
	 	深度优先搜索（DFS）
	 
	 复杂度：       
     time : O(n);
     space : O(n);
     
      
class Solution {
	
	public List<String> binaryTreePaths(TreeNode root) {
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