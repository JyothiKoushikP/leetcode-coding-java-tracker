/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a1 = headA, b1 = headB;
        int l1 = 0, l2 = 0;

        while(a1 != null) {
            a1 = a1.next;
            l1++;
        }

        while(b1 != null) {
            b1 = b1.next;
            l2++;
        }

        a1 = headA; b1 = headB;

        int p = 0;
        if(l1 > l2) {
            while(p < (l1 - l2)) {
                a1 = a1.next;
                p++;
            }
        } else if(l2 > l1) {
            p = 0;
            while(p < (l2 - l1)) {
                b1 = b1.next;
                p++;
            }
        }

        while(a1 != null && b1 != null) {
            if(a1 == b1) {
                return a1;
            }
            a1 = a1.next;
            b1= b1.next;
        }

        return null;
    }
}