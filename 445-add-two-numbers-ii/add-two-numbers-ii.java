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
        ListNode temp = l1;
        int len1 = findLength(temp);
        temp = l2;
        int len2 = findLength(temp);
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        if(len1 > len2) {
            temp2 = increaseLength(l2, len1 - len2);
        } else if(len2 > len1) {
            temp1 = increaseLength(l1, len2 - len1);
        }
        Stack<Integer> track = new Stack<Integer>();
        while(temp1 != null && temp2 != null) {
            int x = temp1.val + temp2.val;
            if(track.isEmpty()) {
                if(x >= 10) {
                    track.push(x / 10);
                }
                track.push(x % 10);
            } else {
                int p = track.pop();
                p += (x / 10);
                track.push(p);
                track.push(x % 10);
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        ListNode pointer = null;
        int carry = 0;
        while(!track.isEmpty()) {
            int popped = track.pop();
            ListNode i = new ListNode((popped + carry) % 10);
            carry = (popped + carry) / 10;
            i.next = pointer;
            pointer = i;
        }
        if(carry != 0) {
            ListNode carryP = new ListNode(carry);
            carryP.next = pointer;
            pointer = carryP;
        }
        return pointer;
    }

    public ListNode increaseLength(ListNode l, int diff) {
        ListNode temp = new ListNode(-1);
        ListNode add = temp;
        int i = 0;
        while(i < diff) {
            ListNode l1 = new ListNode(0);
            add.next = l1;
            add = add.next;
            i++;
        }
        add.next = l;
        return temp.next;
    }

    public int findLength(ListNode temp) {
        int count = 0;
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
}