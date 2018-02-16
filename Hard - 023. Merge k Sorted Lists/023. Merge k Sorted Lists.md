# 题意

合并k个排序链表，并且返回合并后的排序链表。尝试分析和描述其复杂度。

样例

给出3个排序链表`[2->4->null,null,-1->null]`，返回 `-1->2->4->null`

# 思路

第一种思路是用分治的方法，将所有的`list`进行divide and conquer。

对divide出来的链表进行merge操作，就可以得到我们的链表结果。

第二种思路用了优先队列。首先将所有的`list`的入口存到`PriorityQueue`中，然后循环进行判断。每次取出队列中的最小值，并判断该list是否为空，若不为空，那么将list的next值也放到队列中。

# 复杂度

时间复杂度：O(*n*log*k*) k代表链表数目

空间复杂度：O(n)

```java
public class MergekSortedLists {
    /**
     *
     time : O(nlogk) where k is the number of linked lists
     space : O(n)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return sort(lists, 0, lists.length - 1);
    }

    public ListNode sort(ListNode[] lists, int lo, int hi) {
        if (lo >= hi) return lists[lo];
        int mid = (hi - lo) / 2 + lo;
        ListNode l1 = sort(lists, lo, mid);
        ListNode l2 = sort(lists, mid + 1, hi);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        l2.next = merge(l1, l2.next);
        return l2;
    }


    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.add(cur.next);
            }
        }
        return dummy.next;
    }
}
```

