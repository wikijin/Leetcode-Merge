package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : CountCompleteTreeNodes
 * Creator : Edward
 * Description : 222. Count Complete Tree Nodes
 */
public class CountCompleteTreeNodes {
    
    /**
     Given a complete binary tree, count the number of nodes.
     Definition of a complete binary tree from Wikipedia:
     In a complete binary tree every level, except possibly the last, is completely filled, and all nodes
     in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
              3
            /   \
           9     20
         /  \   /  \
        15   7 1
     
     2^h - 1     
     
     题意：
     定了一棵完全二叉树，让我们求其节点的个数。
     
     知识点补充:
     完全二叉树 (Complete Binary Tree)：
     对于一颗二叉树，假设其深度为d（d>1）
     除了第d层外，其它各层的节点数目均已达最大值，且第d层所有节点从左向右连续地紧密排列，这样的二叉树被称为完全二叉树
     完美二叉树 (Perfect Binary Tree)：
     二叉树的第i层至多拥有2^(i-1)个节点数；深度为k的二叉树至多总共有2^(k+1)-1个节点数，而总计拥有节点数匹配的，称为“满二叉树”
     完满二叉树 (Full Binary Tree):
     所有非叶子结点的度都是2（只要你有孩子，你就必然是有两个孩子）
     
     思路：
     1，CBT一定是PBT，而PBT不一定是CBT
     2，这道题给的CBT有可能情况一是PBT，情况二不是PBT，判断是否为PBT则是其最左和最右子节点的高度一样
     3，情况一，节点个数为2^(h+1)-1，h为该树的高度
     4，情况二，递归调用左右节点，通过高度判断子树是否为PBT，总节点个数为左子树的节点个数加上右子树的节点个数再加1(根节点)
     
     复杂度：
     time : O(logn * logn)
     space : O(n) / O(logn) 不确定
     
     * @param root
     * @return
     */
    
    public int countNodes(TreeNode root) {
        // int left = helper(root, true);
        // int right = helper(root, false);
        int left = leftDepth(root);
        int right = rightDepth(root);

        if (left == right) {
            return (1 << left) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int leftDepth(TreeNode root) {
        int res = 0;
        while (root != null) {
            root = root.left;
            res++;
        }
        return res;
    }

    private int rightDepth(TreeNode root) {
        int res = 0;
        while (root != null) {
            root = root.right;
            res++;
        }
        return res;
    }

    private int helper(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        return isLeft ? helper(root.left, isLeft) + 1: helper(root.right, isLeft) + 1;
    }

    public int countNodes2(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode left = root, right = root;
        int height = 0;
        while (right != null) {
            left = left.left;
            right = right.right;
            height++;
        }
        if (left == null)
            return (1 << height) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
