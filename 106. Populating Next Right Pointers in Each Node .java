题意：
     给定一棵二叉树，有一个next指针，将它们的每一层链接起来。只能使用常量额外空间，树是一棵完美二叉树。
     
思路：
     
法一：递归(层序遍历)
     1，从上到下，一层层遍历
     2，由于是完全二叉树，若节点的左子结点存在的话，其右子节点必定存在 -> 左子结点的next直接指向其右子节点
     3，对于其右子节点,判断其父节点的next是否为空，若不为空，则指向其next指针指向的节点的左子结点，若为空则指向NULL
     复杂度：
     time : O(n);
     space : O(lgn);

法二：非迭代
     1，将树的每一层节点用next串起来，这样每一层也会形成一个单链表，每层的链表头则是根的左孩子
     2，利用双循环：外层循环，沿着根的左孩子，一直向下；内层循环，负责将下一层的节点串起来
     复杂度：
     time : O(n);
     space : O(1);
     
视频错误：
     递归的时间复杂度应该是O(lgn)，为树的高度

class Solution {
    public void connect(TreeLinkNode root) { // 法一
        if (root == null) return;
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.next != null && root.right != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }

    //space : O(1)
    public void connect2(TreeLinkNode root) { // 法二
        TreeLinkNode start = root;
        while (start != null) {
            TreeLinkNode cur = start;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            start = start.left;
        }
    }
}
