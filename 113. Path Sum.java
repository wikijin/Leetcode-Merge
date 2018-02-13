	 题意： 
		给出一个二叉树和一个sum值，找出所有从根节点到叶子节点的路径，这些路径需要满足：路径上所有节点的和=sum
  
	 思路：
	 	深度优先搜索（DFS），递归
	 
	 复杂度：  
     time : O(n);
     space : O(n);
     
      
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
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