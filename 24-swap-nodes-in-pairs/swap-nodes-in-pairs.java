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
    public ListNode swapPairs(ListNode head) {
        
        ListNode h = new ListNode(-1);
        ListNode pointer = h;
        ListNode pp = head;
        while(pp != null && pp.next != null) {
            ListNode np = pp.next;
            ListNode npp = np.next;
            pp.next = npp;
            np.next = pp;
            pointer.next = np;
            pointer = pp;
            pp = npp;
        }
        if(pp != null) {
            pointer.next = pp;
        }

        return h.next;
    }
}