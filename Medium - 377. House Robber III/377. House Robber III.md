### 题意

在上次打劫完一条街道之后和一圈房屋之后，窃贼又发现了一个新的可以打劫的地方，**但这次所有的房子组成的区域比较奇怪，聪明的窃贼考察地形之后，发现这次的地形是一颗二叉树**。与前两次偷窃相似的是每个房子都存放着特定金额的钱。你面临的唯一约束条件是：**相邻的房子装着相互联系的防盗系统，且当相邻的两个房子同一天被打劫时，该系统会自动报警**。

算一算，如果今晚去打劫，你最多可以得到多少钱，当然在不触动报警装置的情况下。

### 思路



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
    public int rob(TreeNode root) {
        if (root == null) return 0;
        
        int val = 0;
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }
        
        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }
}
```

