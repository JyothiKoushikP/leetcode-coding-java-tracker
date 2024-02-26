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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null || left == right) {
            return head;
        }
        int c = 1;
        ListNode last = null;
        ListNode start = head;
        while (c < left) {
            last = start;
            start = start.next;
            c++;
        }
        ListNode prev = null;
        ListNode present = start;
        ListNode nextNode = null;
        while (c <= right) {
            nextNode = present.next;
            present.next = prev;
            prev = present;
            present = nextNode;
            c++;
        }
        start.next = present;

        if(last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        return head;
    }

}