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
    public ListNode deleteDuplicates(ListNode head) {
        return deleteDuplicatesR(head,head);
    }

    public ListNode deleteDuplicatesR(ListNode head, ListNode currentNode) {
        if(currentNode == null || currentNode.next == null) {
            return head;
        }
        if(currentNode.val == currentNode.next.val) {
            currentNode.next = currentNode.next.next;
            return deleteDuplicatesR(head,currentNode);
        } else {
            return deleteDuplicatesR(head,currentNode.next);
        }
    }
}