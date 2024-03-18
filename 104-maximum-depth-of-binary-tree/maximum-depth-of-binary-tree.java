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
    public int maxDepth(TreeNode root) {
        return recDepth(root, 1);
    }

    public int recDepth(TreeNode node, int height) {
        if(node == null) {
            return height - 1;
        }
        int leftTreeHeight = recDepth(node.left,height + 1);
        int rightTreeHeight = recDepth(node.right,height + 1);

        return Math.max(leftTreeHeight,rightTreeHeight);
    }
}