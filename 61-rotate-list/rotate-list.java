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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        ListNode countList = head;
        int count = 1;
        while (countList.next != null) {
            countList = countList.next;
            count++;
        }
        countList.next = head;
        k = (k % count);
        int rem = count - k;
        ListNode dummy = head;
        for(int i = 0; i < rem - 1 ; i++) {
            dummy = dummy.next;
        }
        head = dummy.next;
        dummy.next = null;
        return head;
    }
}