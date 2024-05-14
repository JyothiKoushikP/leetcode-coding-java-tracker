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
    public int findBottomLeftValue(TreeNode root) {
        int leftValue = root.val;
        boolean didGetLeftValue = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int curr = 1, next = 0;
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            curr--;
            if(node.left != null) {
                if(!didGetLeftValue) {
                    leftValue = node.left.val;
                    didGetLeftValue = true;
                }
                q.add(node.left);
                next++;
            }

            if(node.right != null) {
                if(!didGetLeftValue) {
                    leftValue = node.right.val;
                    didGetLeftValue = true;
                }
                q.add(node.right);
                next++;
            }

            if(curr == 0) {
                curr = next;
                next = 0;
                didGetLeftValue = false;
            }
        }

        return leftValue;
    }
}