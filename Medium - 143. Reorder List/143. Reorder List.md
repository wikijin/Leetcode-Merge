# 题意

给定一个单链表L: *L*0→*L*1→…→*L*n-1→*L*n,

重新排列后为：*L*0→*L*n→*L*1→*L*n-1→*L*2→*L*n-2→…

必须在不改变节点值的情况下进行原地操作。

# 思路

首先申明一个快节点与慢节点，对链表进行遍历。慢节点每次前进一步，快节点每次前进两步。

当快节点为`null`时，慢节点到达链表中央。

对慢节点的`next`节点进行翻转链表操作，翻转后返回的节点就是链表的末端。

然后将慢节点的`next`设置为`null`。

最后从节点的`head`与链表末端同时进行遍历，并合并成同一个链表。

# 复杂度

时间复杂度：O(n)

空间复杂度：O(1)

```java
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = null;
        ListNode slow = head, fast = head;
        ListNode l1 = head;
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        ListNode l2 = reverse(slow);
        merge(l1, l2);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l1 != l2) {
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;
            l1.next = l2;
            if (n1 == null) break;
            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }
}
```

