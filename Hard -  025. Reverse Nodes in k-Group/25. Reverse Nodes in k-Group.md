# 题意

给你一个链表以及一个*k*,将这个链表从头指针开始每*k*个翻转一下。
链表元素个数不是*k*的倍数，最后剩余的不用翻转。

样例

给出链表 `1->2->3->4->5`

*k* = `2`, 返回 `2->1->4->3->5`

*k* = `3`, 返回 `3->2->1->4->5`

# 思路

这题用递归的思路来解决很方便。

首先遍历链表，若已找到的链表长度等于k，那么对剩下的链表执行同样的函数，并让其返回剩下链表的链表头部。

对于已找到的链表，我们对其进行翻转链表操作。这个在easy题206里已经讲过，就不重复了。

# 复杂度

时间复杂度：O(n)

空间复杂度：O(1)

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        if(k == 1) return head;
        
        int count = 0;
        int cur = head;
        while(count != k && cur != null) {
            count++;
            cur = cur.next;
        }
        
        if(count == k) {
            cur = reverseGroup(cur, k);
            while(count -- > 0) {
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        return head;
        
    }
}
```

