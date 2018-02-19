package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : LargestBSTSubtree
 * Creator : Edward
 * Description : 333. Largest BST Subtree
 */
public class LargestBSTSubtree {
    /**
     Given a binary tree, find the largest subtree which is a Binary Search Tree (BST),
     where largest means subtree with largest number of nodes in it.

     Note:
     A subtree must include all of its descendants.
     Here's an example:
         10
        / \
       5  15
      / \   \
     1   8   7
     /
     null
     The Largest BST Subtree in this case is the highlighted one.
     The return value is the subtree's size, which is 3.

     1, postorder
     2, BST
     3, decide BST

     1 : 1,1,1
     8 : 1,8,8
     5 : 3,1,8
     7 : 1,7,7
     15 : -1,0,0
     
     题意：
     求一棵二分树的最大二分搜索子树，所谓二分搜索树就是满足左<根<右的二分树，我们需要返回这个二分搜索子树的节点个数。
     
     思路：
     DFS：
     题目中给的提示说我们可以用之前那道Validate Binary Search Tree的方法来做，时间复杂度为O(n2)
     这种方法是把每个节点都当做根节点，来验证其是否是BST，并记录节点的个数，若是BST，就更新最终结果返回
     
     Follow up让我们用O(n)的时间复杂度来解决问题：
     1，依然采用DFS的思想，由于时间复杂度的限制，只允许我们遍历一次整个二叉树 -> bottom-up降低时间复杂度
     2，由于题目要求返回最大BST的节点个数，而求BST最大节点个数之前我们还需先判断其是否为BST ->
        这意味着我们需要返回多个值(节点个数需要返回int，是否为bst需要返回boolean或者是两个int边界) ->
        但是一个方程只能返回一个值 ->
        解决该问题的方法可以自己新建一个node class，class中node的fields就是我们需要返回的值 ->
        我们方程仍然只返回一个量(node),但是间接返回了多个量，即node的fields
     3，自己构建新的node class，包含size(以该节点为根的最大BST子树的节点个数),lower、upper(以该节点为根的树中节点最小和最大值)
     4，post-order遍历整个树，通过每个节点构建的新的node，向上返回子树信息
     复杂度：
     time : O(n)
     space : O(n)

     */

    int res = 0;

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }

    private SearchNode helper(TreeNode root) {
        if (root == null) {
            return new SearchNode(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        SearchNode left = helper(root.left);
        SearchNode right = helper(root.right);
        if (left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower) {
            return new SearchNode(-1, 0, 0);
        }
        int size = left.size + right.size + 1;
        res = Math.max(size, res);
        return new SearchNode(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
    }

    class SearchNode {
        int size;
        int lower;
        int upper;

        SearchNode(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
}
