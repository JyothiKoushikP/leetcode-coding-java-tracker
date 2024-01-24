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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        ListNode merged = mergeTwoLists(lists[0],lists[1]);
        for(int i = 2; i < lists.length; i++) {
            merged = mergeTwoLists(merged,lists[i]);
        }
        return merged;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode dummy = head;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            } else {
                 dummy.next = list2;
                 list2 = list2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = (list1 != null) ? list1 : list2;
        return head.next;
    }

}