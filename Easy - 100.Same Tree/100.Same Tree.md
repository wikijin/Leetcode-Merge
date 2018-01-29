### 题意

给定两个二叉树，判断两个二叉树是否相同。

**Example 1:**

```
Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true

```

**Example 2:**

```
Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false

```

**Example 3:**

```
Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
```

### 思路

1. 判断两个节点是否不同
   - 若两节点只有一个为`null`，则返回`false`。
   - 若两节点的值不同，则返回`false`。
2. 若两节点相同，判断两个节点的左右子树是否都相同。
   - 两个节点都为`null`，返回`true`。
   - 两个节点的值相同。

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
    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
```

