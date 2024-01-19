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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode dummy = head;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                ListNode v = new ListNode(list1.val);
                dummy.next = v;
                list1 = list1.next;
            } else {
                 ListNode v = new ListNode(list2.val);
                 dummy.next = v;
                 list2 = list2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = (list1 != null) ? list1 : list2;
        return head.next;
    }
}