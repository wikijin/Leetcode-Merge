### 题意

给出一棵二叉树，返回其节点值从底向上的层次序遍历（按从叶节点所在层到根节点所在的层遍历，然后逐层从左往右遍历）

样例

给出一棵二叉树 `{3,9,20,null,null,15,7}`,

```
    3
   / \
  9  20
    /  \
   15   7
```

按照从下往上的层次遍历为：

```
[
  [15,7],
  [9,20],
  [3]
]
```

### 思路

思路一： 使用`queue`后续遍历

思路二： 使用`helper`函数进行后续遍历，并添加参数`level`来判断在某个`list`中添加。

### 复杂度

时间复杂度：O(n)

空间复杂度：O(n)

```java
public class BinaryTreeLevelOrderTraversalII {
    // queue思路
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                list.add(cur.val);
            }
            res.add(0, list);
        }
        return res;
    }
    // helper 思路
    public static List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root, 0);
        return res;
    }

    public static void helper(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) return;
        if (level >= res.size()) {
            res.add(0, new ArrayList<>());
        }
        res.get(res.size() - level - 1).add(root.val);
        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);

    }

}
```

