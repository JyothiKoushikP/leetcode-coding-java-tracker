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
    int[] max = new int[1];

    public int diameterOfBinaryTree(TreeNode root) {
        int i = recursiveDiameter(root,0);
        return max[0];
    }

    public int recursiveDiameter(TreeNode node, int level) {
        if(node.left == null && node.right == null) {
            return level;
        }
        int ml = level, mr = level;
        if(node.left != null) {
            ml = recursiveDiameter(node.left, level + 1);
        }
        if(node.right != null) {
            mr = recursiveDiameter(node.right, level + 1);
        }
        max[0] = Math.max(max[0],(ml - level) + (mr - level));

        return Math.max(ml,mr);
    }
}