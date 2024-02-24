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
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode sPointer = head;
        ListNode bPointer = head;
        while(sPointer != null && sPointer.val >= x) {
            sPointer = sPointer.next;
        }
        while (bPointer != null && bPointer.val < x) {
            bPointer = bPointer.next;
        }
        if(sPointer == null || bPointer == null) {
            return head;
        }

        ListNode lpp = new ListNode(-1);
        ListNode spp = new ListNode(-1);
        ListNode p1 = lpp;
        ListNode p2 = spp;
        while(sPointer != null) {
            if(sPointer.val < x) {
                p1.next = new ListNode(sPointer.val);
                p1 = p1.next;
            }
            sPointer = sPointer.next;
        }
        while(bPointer != null) {
            if(bPointer.val >= x) {
                p2.next = new ListNode(bPointer.val);
                p2 = p2.next;
            }
            bPointer = bPointer.next;
        }
        p1.next = spp.next;
        return lpp.next;
    }
}