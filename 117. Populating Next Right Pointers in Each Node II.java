题意：
     给定一棵二叉树，有一个next指针，将它们的每一层链接起来。只能使用常量额外空间，树是一棵任意的二叉树。
     
思路：
     非递归：
     1，层序遍历
     2，当不是完全二叉树时，左子节点或者右子节点都有可能为空，每个叶子节点的深度也不一定相同，
        所以退出循环的条件、每层头节点的确定方法以及next指针的赋值都要改变
     3，next指针不再是分左右子节点来直接赋值，而是对记录下来的上个节点的next赋当前操作的节点
     4，退出循环不能再像上一题一样到最后一层就可以退出，因为当前节点会不断更新，只有当前节点为空时才能退出
     5，头节点可能是左子节点，也可能是右子节点
     
复杂度：
     time : O(n);
     space : O(1);

class Solution {    
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = null;
        TreeLinkNode pre = null;
        TreeLinkNode cur = null;
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (pre != null) {
                        pre.next = cur.left;
                    } else head = cur.left;
                    pre = cur.left;
                }
                if (cur.right != null) {
                    if (pre != null) {
                        pre.next = cur.right;
                    } else head = cur.right;
                    pre = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            pre = null;
            head = null;
        }
    }
}
