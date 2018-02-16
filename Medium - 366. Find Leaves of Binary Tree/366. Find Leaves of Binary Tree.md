### 题意

寻找找二叉树的叶节点，并取出当前树的叶子节点。

举例：

```
          1
         / \
        2   3
       / \     
      4   5    

```

Returns `[4, 5, 3], [2], [1]`.

**Explanation:**

1. 取出叶子节点 `[4, 5, 3]` :

```
          1
         / 
        2          

```

1. 取出叶子节点 `[2]` :

```
          1          

```

1. 取出叶子节点 `[1]` :

```
          []         

```

Returns `[4, 5, 3], [2], [1]`.

### 思路

后续遍历该树，根据左右树的深度判断当前的level，从而放到不同的`List`中。

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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        helper(res, root);
        return res;
        
    }
    
    public int helper(List<List<Integer>> res, TreeNode root) {
        if (root == null) return -1;

        
        int left = helper(res, root.left);
        int right = helper(res, root.right);
        int level = Math.max(left, right) + 1;
        
        if (level >= res.size()) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);
        root.left = null;
        root.right = null;
        return level;
        
    }
}
```

