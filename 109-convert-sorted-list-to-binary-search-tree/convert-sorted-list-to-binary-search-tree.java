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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        List<Integer> elements = new ArrayList<>();
        while(head != null) {
            elements.add(head.val);
            head = head.next;
        }
        return createTree(elements, 0, elements.size() - 1);
    }

    public TreeNode createTree(List<Integer> elements, int low, int high) {
        if(low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode n = new TreeNode(elements.get(mid));
        n.left = createTree(elements, low, mid - 1);
        n.right = createTree(elements, mid + 1, high);
        return n;
    }

}