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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode prev = null, present = head;
        while(present != null) {
            if(present.val == val) {
                ListNode n = present.next;
                if(prev == null) {
                    head = n;
                    present = head;
                } else {
                    prev.next = n;
                    present = n;
                }
            } else {
                prev = present;
                present = present.next;
            }
        }
        return head;
    }
}