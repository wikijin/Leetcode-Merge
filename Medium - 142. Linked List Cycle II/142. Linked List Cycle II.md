# 题意

给定一个链表，如果链表中存在环，则返回到链表中环的起始节点，如果没有环，返回null。

# 思路

首先申明一个快节点与慢节点，快节点每次前进两步，慢节点每次前进一步。若快节点为`null`那么该链表没有环，返回`null`。

当快节点与慢节点重合时，我们再申明一个节点从`head`出发，慢节点与`head`节点一起前进一步，当两个节点重合时，重合的节点就是环的起始节点。

进一步解释：如果进入环之前，链表中有单向链表，举例如下：

1->2->3->4->5->6->7, 且7->3。

那么快慢节点重合的位置不是环的起始节点，而是距离起始节点2个节点，也就是位置6。原因是快慢节点出发时的位置离起始点偏移了两个节点。

这时我们需要从链表头进行遍历，并从重合的节点位置同时遍历，当两个节点重合时，该位置就是起始点。

# 复杂度

时间复杂度：O(n)

空间复杂度：O(1)

```java
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode slow2 = head;
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
```

