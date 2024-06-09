/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeList(left,right);
    }

    public ListNode mergeList(ListNode l, ListNode r) {
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        while(l != null && r != null) {
            if(l.val <= r.val) {
                dummy.next = l;
                l = l.next;
            } else {
                 dummy.next = r;
                 r = r.next;
            }
            dummy = dummy.next;
        }
        dummy.next = (l != null) ? l : r;
        return head.next;
    }

    public ListNode getMid(ListNode lh) {
        ListNode slow = lh, fast = lh;
        ListNode prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }

}