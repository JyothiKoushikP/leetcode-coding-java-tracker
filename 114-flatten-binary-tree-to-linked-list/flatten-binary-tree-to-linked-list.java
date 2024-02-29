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
    public void flatten(TreeNode root) {
        if(root == null) return;
        Queue<Integer> q = new LinkedList<>();
        preOrderTraversal(q,root);
        root.left = null;
        root.right = null;
        TreeNode pointer = root;
        q.remove();
        while(!q.isEmpty()) {
            TreeNode node = new TreeNode(q.remove());
            pointer.right = node;
            pointer = node;
        }
    }

    public void preOrderTraversal(Queue<Integer> q, TreeNode node) {
        if(node == null) {
            return;
        }
        q.add(node.val);
        preOrderTraversal(q,node.left);
        preOrderTraversal(q,node.right);
    }
}