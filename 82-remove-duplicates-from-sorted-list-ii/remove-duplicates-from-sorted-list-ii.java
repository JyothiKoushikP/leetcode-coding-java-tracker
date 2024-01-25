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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode result = new ListNode(-1);
        ListNode tr = result;
        ListNode curr = head, incr = head.next;
        while (incr != null) {
            if(curr.val != incr.val) {
                tr.next = curr;
                tr = tr.next;
                curr = curr.next;
                incr = incr.next;
            } else {
                while (incr != null && curr.val == incr.val) {
                    incr = incr.next;
                }
                curr = incr;
                incr = (incr != null) ? incr.next : null;
            }
        }
        tr.next = curr;
        return result.next;
    }
}