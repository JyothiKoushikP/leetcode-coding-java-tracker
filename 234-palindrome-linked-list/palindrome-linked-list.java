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
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        int count = 0;

        while (fast != null && fast.next != null) {
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
        
        for(int i = 0; i < count; i++) {
            if(head.val != prev.val) {
                return false;
            }
            head = head.next;
            prev = prev.next;
        }
        
        return true;
    }
}