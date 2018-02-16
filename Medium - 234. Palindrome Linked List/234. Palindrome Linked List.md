# 题意

设计一种方式检查一个链表是否为回文链表。

# 思路

首先通过一个快指针与慢指针对链表进行遍历，快指针每次前进两步，慢指针每次前进一步。

当快指针到达链表尽头，慢指针则到达链表中央。

此时我们从链表中央开始，向右进行翻转链表，这样链表右半边就翻转过来。如下所示：

1->2->3->4->null null<-4<-3<-2<-1。

最后从链表的两侧向中心进行遍历，若两侧的值不同，则链表不是回文链表。若都相同，则链表是回文链表。

# 复杂度

空间：O(1)

时间：O(n)

```java
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode middle = findMiddle(head);
        middle.next = reverse(middle.next);

        ListNode p = head;
        ListNode q = middle.next;
        while (p != null && q != null) {
            if (p.val != q.val) return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
```







