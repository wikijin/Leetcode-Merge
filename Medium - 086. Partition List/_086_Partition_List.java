package leetcode;

public class PartitionList {
    /**
     time : O(n)
     space : O(n)
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0),
                bigHead = new ListNode(0),
                small = smallHead,
                big = bigHead;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            if (head.val < x) {
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