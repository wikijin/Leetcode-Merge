题意：
     给定一个二叉树的后序遍历和中序遍历，构造出一颗二叉树。
     
思路：
     递归
     这道题和105.Construct Binary Tree from Preorder and Inorder Traversal思路完全一样，详情参看105
     1，区别是要从中序遍历和后序遍历中构造出树，算法还是一样，只是现在取根是从后面取（因为后序遍历根是遍历的最后一个元素）
     2，后续遍历的最后一个节点为根节点。
     3，中序遍历中根节点是左子树右子树的分割点
     
复杂度：
     time : O(n)
     space : O(n)

class Solution {
    int pInorder;
    int pPostorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pInorder = inorder.length - 1;
        pPostorder = postorder.length - 1;
        return helper(inorder, postorder, null);
    }

    public TreeNode helper(int[] inorder, int[] postorder, TreeNode end) {
        if (pPostorder < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pPostorder--]);
        if (inorder[pInorder] != root.val) {
            root.right = helper(inorder, postorder, root);
        }
        pInorder--;
        if ((end == null) || (inorder[pInorder] != end.val)) {
            root.left = helper(inorder, postorder, end);
        }
        return root;
    }
}
