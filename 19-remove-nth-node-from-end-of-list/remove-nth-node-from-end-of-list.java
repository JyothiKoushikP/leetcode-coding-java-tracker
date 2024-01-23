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
        ListNode present = head;
        while (present != null) {
            present = present.next;
            count++;
        }
        int k = count;
        ListNode newNode = head, prev = null;
        while (newNode != null && count > n) {
            prev = newNode;
            newNode = newNode.next;
            count--;
        }
        if(prev == null) {
            return head.next;
        } else {
            prev.next = newNode.next;
        }

        return head;
    }
}