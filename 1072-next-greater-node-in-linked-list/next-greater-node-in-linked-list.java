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
    public int[] nextLargerNodes(ListNode head) {
        ListNode prev = null, present = head;
        int count = 0;
        
        while(present != null) {
            ListNode next = present.next;
            present.next = prev;
            prev = present;
            present = next;
            count++;
        }

        Stack<Integer> track = new Stack<Integer>();
        int[] result = new int[count];
        int p = 0;
        while(prev != null) {
              if(track.isEmpty()) {
                    result[p++] = 0;
                    track.push(prev.val);
                } else if(track.peek() <= prev.val) {
                    while(!track.isEmpty() && track.peek() <= prev.val) {
                        track.pop();
                    }
                    result[p++] = track.isEmpty() ? 0 : track.peek();
                    track.push(prev.val);
                }
                else {
                    result[p++] = track.peek();
                    track.push(prev.val);
                }
                prev = prev.next;
        }
        int start = 0, end = result.length - 1;
        while(start <= end) {
            int temp = result[start];
            result[start] = result[end];
            result[end] = temp;
            start++;
            end--;
        }
        return result;
    }
}