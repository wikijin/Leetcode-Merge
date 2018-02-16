# 题意

用插入排序对链表排序

样例

Given `1->3->2->0->null`, return `0->1->2->3->null`

# 思路

遍历链表，若当前节点的下个节点值大于当前节点，则继续遍历。

否则将下个节点取出，遍历链表，找到该节点排序后的位置。

# 复杂度

时间复杂度：O(n^2)

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
    public ListNode insertionSortList(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode temp = null, prev = null;
        
        while(cur != null && cur.next != null) {
            if (cur.val <= cur.next.val) {
                cur = cur.next;
            } else {
                temp = cur.next;
                cur.next = temp.next;
                prev = dummy;
                while(prev.next.val <= temp.val) {
                    prev = prev.next;
                }
                temp.next = prev.next;
                prev.next = temp;
                
            }
        }
        return dummy.next;
    }
}
```

