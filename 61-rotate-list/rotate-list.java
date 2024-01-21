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
        int count = 0;
        while (countList != null) {
            countList = countList.next;
            count++;
        }
        k = (k % count);
        ListNode dummy = head;
        while (k > 0) {
            ListNode temp = dummy;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            ListNode last = temp.next;
            temp.next = null;
            ListNode old = dummy;
            dummy = last;
            last.next = old;
            k--;
        }
        return dummy;
    }
}