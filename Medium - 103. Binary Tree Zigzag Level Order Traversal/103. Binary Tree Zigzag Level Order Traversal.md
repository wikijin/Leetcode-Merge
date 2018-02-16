### 题意

给出一棵二叉树，返回其节点值的锯齿形层次遍历（先从左往右，下一层再从右往左，层与层之间交替进行） 

给出一棵二叉树 `{3,9,20,#,#,15,7}`,

```
    3
   / \
  9  20
    /  \
   15   7
```

返回其锯齿形的层次遍历为：

```
[
  [3],
  [20,9],
  [15,7]
]
```

### 思路

与107基本相同，也是可以通过`queue`或者`helper`函数进行BFS遍历。

只是用`queue`更方便，因为可以反序插入节点值。

### 复杂度

时间复杂度：O(n)

空间复杂度：O(n)

```java
public class BinaryTreeZigzagLevelOrderTraversal {
    /**
     time : O(n)
     space : O(n);
     * @param root
     * @return
     */

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean x = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (x) {
                    list.add(cur.val);
                } else {
                    list.add(0, cur.val);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(list);
            x = x ? false : true;
        }
        return res;
    }
}
```

