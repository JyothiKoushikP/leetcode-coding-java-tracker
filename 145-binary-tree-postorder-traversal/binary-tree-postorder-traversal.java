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

    public List<Integer> postorderTraversal(TreeNode root) {
        pTraversal(root);
        return result;
    }

    public void pTraversal(TreeNode node) {
        if(node == null) {
            return;
        }
        pTraversal(node.left);
        pTraversal(node.right);
        result.add(node.val);
        return;
    }

}