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

    public int recDepth(TreeNode root, int level) {
        if(root == null) {
            return level - 1;
        }
        if(root.left == null && root.right == null) {
            return level;
        }
        int max1 = 0, max2 = 0;
        if(root.left != null) {
            max1 = recDepth(root.left, level + 1);
        }
        if(root.right != null) {
            max2 = recDepth(root.right, level + 1);
        }

        return Math.max(max1,max2);
    }
}