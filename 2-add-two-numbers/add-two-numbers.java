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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode prev = null;
        ListNode fn = l1, sn = l2;
        while(fn != null || sn != null) {
            int fv = fn != null ? fn.val : 0;
            int sv = sn != null ? sn.val : 0;
            int value = (fv + sv + carry) % 10;
            carry = (fv + sv + carry) / 10;
            if(sn == null) {
                ListNode node = new ListNode(value);
                prev.next = node;
                prev = node;
            } else {
                sn.val = value;
                prev = sn;
                sn = sn.next;
            }
            if(fn != null) {
                fn = fn.next;
            }
        }
        if(carry != 0) {
            ListNode node = new ListNode(carry);
            prev.next = node;
        }
        return l2;
    }
}