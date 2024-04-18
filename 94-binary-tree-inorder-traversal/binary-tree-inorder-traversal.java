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
    List<Integer> result = new ArrayList();

    public List<Integer> inorderTraversal(TreeNode root) {
        iTraversal(root);
        return result;
    }

    public void iTraversal(TreeNode node) {
        if(node == null) {
            return;
        }
        inorderTraversal(node.left);
        result.add(node.val);
        inorderTraversal(node.right);
        return;
    }
}