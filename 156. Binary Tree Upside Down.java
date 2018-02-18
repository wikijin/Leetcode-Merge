     题意：
        这道题让我们把一棵二叉树上下颠倒一下，而且限制了右节点要么为空要么一定会有对应的左节点。上下颠倒后原来二叉树的最左子节点变成了根节点，其对应的右节点变成了其左子节点，其父节点变成了其右子节点，相当于以最左子节点为轴顺时针90度旋转了一下。
     
     思路：
        有递归和迭代两种解法：
        递归：
        1，首先判断这个根节点是否存在，若没有，直接返回即可，不需要翻转操作
        2，目标是返回新的根节点(原树最左子节点)，不停对左子节点进行递归调用，直到到达最左子节点开始翻转
        3，翻转好最左子节点后，开始回到上一个左子节点继续翻转即可，直到从下往上翻转完整棵树
        4，注意存储最左子节点(newRoot)用于最后返回
        迭代：
        1，和递归方法的思路一致
        2，和递归操作方向相反，这个是从上往下开始翻转，直至翻转到最左子节点
     
     复杂度：
     time : O(n);
     space : O(n);

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode upsideDownBinaryTree(TreeNode root) {
            if (root == null || root.left == null && root.right == null) {
                return root;
            }
            TreeNode newRoot = upsideDownBinaryTree(root.left);
            root.left.left = root.right;
            root.left.right = root;
            
            root.left = null;
            root.right = null;
            return newRoot;
        }
    }
