# 题意

给定一个单链表和数值x，划分链表使得所有小于x的节点排在大于等于x的节点之前。

你应该保留两部分内链表节点原有的相对顺序。

样例

给定链表 `1->4->3->2->5->2->null`，并且 x=3

返回 `1->2->2->4->3->5->null` 

# 思路

构建两个链表指针`smallHead`与`bigHead`， 然后遍历整个链表，所有大于`x`的节点，将其添加到`bigHead`之后，否则添加到`smallHead`后。

最后将`smallHead`与`bigHead`拼接起来，就得到了最终的链表结果。

# 复杂度

时间复杂度：O(n)

空间复杂度：O(n)

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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        
        ListNode smallHead = new ListNode(0), 
        bigHead = new ListNode(0),
        small = smallHead,
        big = bigHead;
        
        while(head != null) {
            ListNode temp = new ListNode(head.val);
            if(head.val < x) {
                small.next = temp;
                small = small.next;
            } else {
                big.next = temp;
                big = big.next;
            }
            head = head.next;
        }
        small.next = bigHead.next;
        return smallHead.next;
        
    }
}
```

