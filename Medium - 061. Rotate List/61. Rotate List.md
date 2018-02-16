# 题意

给定一个链表，旋转链表，使得每个节点向右移动k个位置，其中k是一个非负数

# 思路

将单向链表的末尾连接到头部，构成环。

将环的第`len - k % len`位置的节点断开，下一个节点是新的链表头。如下所示

k = 3

1-2-3-4-5-6-7=> 1-2-3-4-5-6-7, 7-1 =>断开4-5之间的链接，取5为新的链表头。

则可得5-6-7-1-2-3-4。

# 复杂度

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if( head == null || head.next == null) return head;
        int len = 1;
        ListNode index = head;
        while(index.next != null) {
            index = index.next;
            len++;
        }
        index.next = head;
        
        for(int i = 1; i <  len - k % len; i++) {
            head = head.next;
        }
        ListNode res = head.next;
        head.next = null;
        return res;
    }
}
```

