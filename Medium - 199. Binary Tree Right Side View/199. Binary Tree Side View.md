### 题意

Given a binary tree, imagine yourself standing on the *right* side of it, return the values of the nodes you can see ordered from top to bottom.

输出二叉树每层的最右节点。

样例：

```
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

```

返回 `[1, 3, 4]`.

### 思路

思路一：用`queue`进行BFS遍历，返回每层`queue`的最右节点。

思路二：用`helper`函数进行BFS遍历，注意向下递归时应该先右子树，再左子树。

### 复杂度

时间复杂度：O(n)

空间复杂度：O(n)

```java
public class BinaryTreeRightSideView {
    // helper BFS遍历
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root, 0);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root, int level) {
        if (root == null) return;
        if (res.size() == level) {
            res.add(root.val);
        }
        helper(res, root.right, level + 1);
        helper(res, root.left, level + 1);
    }

    // queue BFS遍历
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) res.add(cur.val);
                if (cur.right != null) queue.offer(cur.right);
                if (cur.left != null) queue.offer(cur.left);
            }
        }
        return res;
    }
}
```

