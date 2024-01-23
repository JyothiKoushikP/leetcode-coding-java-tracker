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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode first = prev;
        ListNode second = prev;
        while (first != null) {
            if(count > n) {
                second = second.next;
            }
            first = first.next;
            count++;
        }

        second.next = second.next.next;
        return prev.next;
    }
}