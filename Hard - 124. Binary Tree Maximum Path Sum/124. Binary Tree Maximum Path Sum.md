## 题意

给出一棵二叉树，寻找一条路径使其路径和最大，路径可以在任一节点中开始和结束（路径和为两个节点之间所在路径上的节点权值之和）

样例

给出一棵二叉树：

```
       1
      / \
     2   3

```

返回 `6`

## 思路

首先建立一个`res`值来保存全局最大值，然后后序遍历每个节点。

每次遍历时，比较当前的最大值与`res`的大小，若`res`小于当前的最大值，则替换当前`res`，最终返回当前的最大值。

## 复杂度

time: O(n)

space: O(n)

## 代码

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
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }
    
    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
```

