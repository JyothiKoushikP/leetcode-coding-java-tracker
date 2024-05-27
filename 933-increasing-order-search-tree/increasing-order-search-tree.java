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
    List<Integer> result;
    public TreeNode increasingBST(TreeNode root) {
        result = new ArrayList<>();
        inOrder(root);
        TreeNode res = new TreeNode(-1);
        TreeNode iter = res;
        for(int i: result) {
            TreeNode node = new TreeNode(i);
            iter.right = node;
            iter = iter.right;
        }
        return res.right;
    }

    public void inOrder(TreeNode node) {
        if(node.left == null && node.right == null) {
            result.add(node.val);
            return;
        }
        if(node.left != null) {
            inOrder(node.left);
        }
        result.add(node.val);
        if(node.right != null) {
            inOrder(node.right);
        }
        return;
    }
}