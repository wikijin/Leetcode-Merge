     题意：
     把二叉树展开成链表(就地操作)。
     
     思路：
     
     法一：
     递归 (右->左->根遍历，不常见的解法，不具有代表性)
     1，设置静态变量prev用于保留上一节点，初始置为0
     2，先递归调用右孩子，再递归调用左孩子，最后进行节点间连接的变换操作
     3，当前节点right连接pre，当前节点左孩子置为null(注意!)，把当前节点赋给pre
     4，注意对于每一个节点操作时，需要把其左孩子均置为null
     复杂度：
     time : O(n)
     space : O(n)

     法二：
     递归 (后序遍历(左->右->根)，这个思路比较有代表性，运行时间也比上一个快)
     1，先flatten左子树，再flatten右子树，然后连接 根节点 -> 左子树(flattened) -> 右子树(flattened)
     2，记得保留右孩子用于之后的连接
     3，注意对于每一个节点操作时，需要把其左孩子均置为null
     复杂度：
     time : O(n)
     space : O(n)
     
     法三：
     Stack (FILO--先进后出)
     只是提供一种思路，但不满足该题的in-place就地操作
     1，类似于先序遍历的模式，首先将根节点push进栈
     2，while循环直至栈为空，先右后坐若子节点不为null则push进栈
     3，对pop出来的节点进行操作，将其右接栈顶的节点，左接null
     复杂度：
     time : O(n)
     space : O(n)

class Solution {
    private TreeNode prev = null; // 法一

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public void flatten1(TreeNode root) { // 法二
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode right = root.right;      // save current right for concatination
        if (root.left != null) {
            root.right = root.left;       // step 1: concatinate root with left flatten subtree
            root.left = null;             // step 2: set root.left = null
            while (root.right != null) root = root.right; // step 3: move to the end of new added flatten subtree
            root.right = right;           // step 4: contatinate left flatten subtree with flatten right subtree
        }
    }

    public void flatten2(TreeNode root) { // 法三
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
            if (!stack.isEmpty()) {
                cur.right = stack.peek();
            }
            cur.left = null;
        }
    }
}
