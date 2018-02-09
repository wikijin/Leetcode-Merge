### 题意

求出二叉树中相同值子树的个数

### 思路

后序遍历该树，判断左子树与右子树是否相同。

当遍历左子树与右子树都会返回`true`并且非`null`，那么判断左右子树的值是否等于`root`的值，若都满足，则相同值子树的数目加一，返回`true`。

### 复杂度

时间复杂度：O(n)

空间复杂度：O(n)

```java
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
    int res;
    public int countUnivalSubtrees(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }
    
    public boolean helper(TreeNode root) {
        if (root == null) return true;
        
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if (left && right) {
            if (root.left != null && root.val != root.left.val)
                return false;
            if (root.right != null && root.val != root.right.val)
                return false;
            res++;
            return true;
        }
        return false;   
    }
}
```

