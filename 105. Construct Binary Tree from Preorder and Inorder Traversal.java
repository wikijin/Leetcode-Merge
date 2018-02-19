题意：
     给定一个二叉树的先序遍历和中序遍历，构造出一颗二叉树。
     
思路：
     递归
     1，先序遍历的从左数第一个为整棵树的根节点
     2，中序遍历中根节点是左子树右子树的分割点
     3，例子解释，以下面的二叉树为例
              4
            /   \
           2     7
          / \   / \
         1   3 6   9
     先序遍历：【4 2 1 3 7 6 9】
     中序遍历：【1 2 3 4 6 7 9】
     对先序遍历来说：
     先序遍历的每个值表示的结点都是接下来的若干结点的父结点。
     比如【4】是这个二叉树的根结点。
     【2】是【1 3】的父结点。
     【1】是 空的父结点，也即使叶子结点。
     
     对中序遍历来说：
     根结点一定在中间位置，中间左边是左子树，右边是右子树。
     比如【4】左边是【1 2 3】是根结点的左子树，右边是【6 7 9】是根结点的右子树。
     对于【2】来说，【1】是其左子树，【3】是其右子树。
     4，注意数组边界的check
     
复杂度：
     time : O(n)
     space : O(n)

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

}
