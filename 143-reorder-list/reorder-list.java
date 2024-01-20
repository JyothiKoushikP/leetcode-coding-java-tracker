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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        //slow and fast pointer
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }

        ListNode prev = null;
        ListNode present = slow;
        while (present != null) {
            ListNode next = present.next;
            present.next = prev;
            prev = present;
            present = next;
        }
        ListNode dummy = head;
        for(int i = 0; dummy != null && i < count; i++) {
            ListNode node = dummy.next;
            dummy.next = prev;
            prev = prev.next;
            dummy.next.next = node;
            dummy = node;
        }
        dummy.next = null;
    }
}