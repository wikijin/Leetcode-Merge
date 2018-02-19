package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : UniqueBinarySearchTrees
 * Creator : Edward
 * Description : 96. Unique Binary Search Trees
 */
public class UniqueBinarySearchTrees {
    /**
     Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

     For example,
     Given n = 3, there are a total of 5 unique BST's.

     1         3     3      2      1
      \       /     /      / \      \
       3     2     1      1   3      2
      /     /       \                 \
     2     1         2                 3

     n = 3
     root : 1   left : 0 right : 2   f(0) * f(2);
     root : 2   left : 1 right : 1   f(1) * f(1);
     root : 3   left : 2 right : 0   f(2) * f(0);

     f(n) = f(0)*f(n-1) + f(1)*f(n-2) + ... + f(n-2)*f(1) + f(n-1)*f(0)
     
     题意：
     给定一个数n，求1到n这些数可以构成多少棵二叉树。
     
     思路：
     动态规划
     1，给定一个序列1.....n，为了构造所有二叉树，我们可以使用1......n中的每一个数i作为根节点
     2，1......(i-1)必然位于树的左子树中，(i+1).....n位于树的右子树中，然后递归来构建左右子树
     3，由于根节点是唯一的，所以构建的二叉树都是唯一的，以这个节点为根的可行二叉树数量就是左右子树可行二叉树数量的乘积
     4，转移方程：f(n) = f(0)*f(n-1) + f(1)*f(n-2) + ... + f(n-2)*f(1) + f(n-1)*f(0)，注意f[0]=1
     
     复杂度：
     time : O(n);
     space : O(n);
     
     * @param n
     * @return
     */

    public int numTrees(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                res[i] += res[j] * res[i - j - 1];
            }
        }
        return res[n];
    }
}
